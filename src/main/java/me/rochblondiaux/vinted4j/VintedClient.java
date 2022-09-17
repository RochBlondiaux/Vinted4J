package me.rochblondiaux.vinted4j;

import kotlin.Pair;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;
import me.rochblondiaux.vinted4j.exceptions.ExceptionallyHandler;
import me.rochblondiaux.vinted4j.factory.RequestFactory;
import me.rochblondiaux.vinted4j.http.ResponseHandler;
import me.rochblondiaux.vinted4j.http.request.VintedRequest;
import me.rochblondiaux.vinted4j.http.request.authentification.ChallengeRequest;
import me.rochblondiaux.vinted4j.http.request.authentification.OAuthTokenRequest;
import me.rochblondiaux.vinted4j.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.http.response.authentification.ChallengeResponse;
import me.rochblondiaux.vinted4j.http.response.authentification.OAuthTokenResponse;
import me.rochblondiaux.vinted4j.model.OAuthToken;
import me.rochblondiaux.vinted4j.model.device.AndroidDevice;
import me.rochblondiaux.vinted4j.model.user.User;
import me.rochblondiaux.vinted4j.tasks.UserDetailsTask;
import me.rochblondiaux.vinted4j.utils.VintedUtils;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

@Data
@Log4j2
public class VintedClient {

    private static VintedClient instance;

    // Credentials
    private final String username;
    private final String password;

    // HTTP Client
    @Accessors(chain = true)
    private transient OkHttpClient client;
    @Accessors(chain = true)
    private AndroidDevice device;
    @Accessors(chain = true)
    private transient OAuthToken token;

    // State
    @Setter(AccessLevel.PRIVATE)
    private boolean loggedIn = false;
    private String deviceId;
    private String anonId;

    // Misc
    @Accessors(chain = true)
    private transient ExceptionallyHandler exceptionallyHandler;
    private User user;

    // Tasks
    private final transient UserDetailsTask detailsTask;

    public VintedClient(String username, String password) {
        this(username, password, VintedUtils.defaultHttpClientBuilder().build());
    }

    public VintedClient(String username, String password, OkHttpClient client) {
        this.username = username;
        this.password = password;
        this.anonId = VintedUtils.randomUuid();
        this.deviceId = VintedUtils.generateDeviceId(username, password);
        this.client = client;
        this.detailsTask = new UserDetailsTask(this);

        this.exceptionallyHandler = new ExceptionallyHandler() {
            @Override
            public <T> T handle(Throwable throwable, Class<T> type) {
                throw new CompletionException(throwable.getCause());
            }
        };
        instance = this;
    }

    public CompletableFuture<VintedClient> login() {
        log.info("Logging in...");
        CompletableFuture<VintedClient> future = new CompletableFuture<>();

        // Pre Login
        log.info("Requesting an OAuth token...");
        this.sendRequest(new OAuthTokenRequest(new OAuthTokenRequest.OAuthTokenPayload()))
                .exceptionally(throwable -> this.exceptionallyHandler.handle(throwable, OAuthTokenResponse.class))
                .thenApply(preLoginResponse -> {
                    this.token = new OAuthToken(preLoginResponse);
                    log.info("OAuth token received.");

                    // Challenge
                    log.info("Requesting a challenge...");
                    return this.sendRequest(new ChallengeRequest())
                            .exceptionally(throwable -> this.exceptionallyHandler.handle(throwable, ChallengeResponse.class))
                            .thenAccept(challengeResponse -> {
                                if (!challengeResponse.isVerified()) {
                                    future.completeExceptionally(new RuntimeException("Challenge response is not verified"));
                                    return;
                                }
                                log.info("Challenge passed!");

                                // Login
                                log.info("Logging in...");
                                this.sendRequest(new OAuthTokenRequest(new OAuthTokenRequest.LoginTokenPayload(challengeResponse.getUuid(), this.username, this.password)))
                                        .exceptionally(throwable -> ExceptionallyHandler.WRAPPED_TO_RESPONSE.handle(throwable, OAuthTokenResponse.class))
                                        .thenAccept(loginResponse -> {
                                            final OAuthToken token = new OAuthToken(loginResponse);
                                            if (token.getToken() == null) {
                                                future.completeExceptionally(new RuntimeException("Unable to login! Reason: %s (%s)".formatted(loginResponse.getError(), loginResponse.getErrorDescription())));
                                                return;
                                            }
                                            log.info("Logged in!");
                                            this.token = token;
                                            loggedIn = true;
                                            detailsTask.start();
                                            future.complete(this);
                                        });
                            });
                });
        return future;
    }

    public <R extends VintedResponse, T extends VintedRequest<R>> CompletableFuture<R> sendRequest(T request) {
        final CompletableFuture<Pair<Response, String>> responseFuture = new CompletableFuture<>();

        log.info("Sending request : {}", request.url(this));
        this.client.newCall(RequestFactory.get(this, request))
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        responseFuture.completeExceptionally(e);
                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response res) throws IOException {
                        log.info("Response for {} : {}", call.request().url().toString(), res.code());
                        try (ResponseBody body = res.body()) {
                            assert body != null;
                            responseFuture.complete(new Pair<>(res, body.string()));
                        }
                    }
                });
        return responseFuture
                .thenApply(res -> {
                    log.info("Response for {} with body (truncated) : {}",
                            res.getFirst().request().url(),
                            VintedUtils.truncate(res.getSecond()));
                    return new ResponseHandler<>(request).parseResponse(res);
                });
    }


    @Accessors(fluent = true)
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Builder {

        // Credentials
        private String username;
        private String password;

        // HTTP Client
        private OkHttpClient client;
        private AndroidDevice device;

        public VintedClient build() {
            Objects.requireNonNull(username, "Username cannot be null");
            Objects.requireNonNull(password, "Password cannot be null");

            return new VintedClient(username, password, Optional.ofNullable(client).orElseGet(() -> VintedUtils.defaultHttpClientBuilder().build()))
                    .setDevice(Optional.ofNullable(device).orElseGet(() -> AndroidDevice.GOOD_DEVICES[0]));
        }
    }

    public static VintedClient get() {
        return instance;
    }
}
