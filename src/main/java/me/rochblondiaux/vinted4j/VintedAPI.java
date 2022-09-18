package me.rochblondiaux.vinted4j;

import com.github.philippheuer.events4j.core.EventManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;
import me.rochblondiaux.vinted4j.exceptions.ExceptionallyHandler;
import me.rochblondiaux.vinted4j.model.device.AndroidDevice;
import me.rochblondiaux.vinted4j.model.events.authentification.LoginEvent;
import me.rochblondiaux.vinted4j.model.events.authentification.LogoutEvent;
import me.rochblondiaux.vinted4j.model.events.authentification.PreLoginEvent;
import me.rochblondiaux.vinted4j.model.http.request.authentification.ChallengeRequest;
import me.rochblondiaux.vinted4j.model.http.request.authentification.LogoutRequest;
import me.rochblondiaux.vinted4j.model.http.request.authentification.OAuthTokenRequest;
import me.rochblondiaux.vinted4j.model.http.request.user.UserInformationRequest;
import me.rochblondiaux.vinted4j.model.http.response.authentification.ChallengeResponse;
import me.rochblondiaux.vinted4j.model.http.response.authentification.OAuthTokenResponse;
import me.rochblondiaux.vinted4j.model.http.response.user.UserInformationResponse;
import me.rochblondiaux.vinted4j.model.session.OAuthToken;
import me.rochblondiaux.vinted4j.model.session.VintedSession;
import me.rochblondiaux.vinted4j.model.user.User;
import me.rochblondiaux.vinted4j.service.RequestService;
import me.rochblondiaux.vinted4j.task.OAuthRefreshTask;
import me.rochblondiaux.vinted4j.task.UserDetailsTask;
import me.rochblondiaux.vinted4j.utils.CookiesInterceptor;
import me.rochblondiaux.vinted4j.utils.VintedUtils;
import okhttp3.OkHttpClient;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

@Data
@Log4j2
public class VintedAPI {

    // Credentials
    private final String username;
    private final String password;

    // Http
    @Accessors(chain = true)
    private final OkHttpClient httpClient;
    private final AndroidDevice device;

    // Session
    private final VintedSession session;
    @Accessors(chain = true)
    private transient ExceptionallyHandler exceptionallyHandler;

    // Services
    private final RequestService requestService;
    private final EventManager eventManager;

    private VintedAPI(String username, String password, OkHttpClient httpClient, AndroidDevice device) {
        this.username = username;
        this.password = password;
        this.httpClient = new OkHttpClient.Builder(httpClient)
                .addInterceptor(new CookiesInterceptor(this))
                .build();
        this.device = device;

        this.session = new VintedSession(username, password);
        this.eventManager = new EventManager();
        this.eventManager.autoDiscovery();
        this.requestService = new RequestService(this);
        this.exceptionallyHandler = new ExceptionallyHandler() {
            @Override
            public <T> T handle(Throwable throwable, Class<T> type) {
                throw new CompletionException(throwable.getCause());
            }
        };

        // Runtime
        this.startRuntime();
    }

    /**
     * Start vinted api runtime;
     */
    private void startRuntime() {
        new UserDetailsTask(this).start();
        new OAuthRefreshTask(this).start();
    }

    /**
     * Login into Vinted with the given credentials.
     *
     * @return A {@link CompletableFuture} that will be completed when the login is done.
     */
    public CompletableFuture<User> login() {
        CompletableFuture<User> future = new CompletableFuture<>();
        eventManager.publish(new PreLoginEvent(username, password));
        log.info("Logging in as {}...", username);

        // Guest Token
        log.info("Requesting guest token...");
        requestService.send(new OAuthTokenRequest(new OAuthTokenRequest.GuestPayload()))
                .exceptionally(throwable -> this.exceptionallyHandler.handle(throwable, OAuthTokenResponse.class))
                .thenAccept(guestTokenResponse -> {
                    final OAuthToken guestToken = guestTokenResponse.token();
                    if (guestToken == null || !guestToken.isValid()) {
                        eventManager.publish(new LoginEvent(LoginEvent.Result.FAILURE, null));
                        future.completeExceptionally(new RuntimeException("Unable to get guest token! Cause: %s (%s)".formatted(guestTokenResponse.getError(), guestTokenResponse.getErrorDescription())));
                        return;
                    }
                    log.info("Guest token received.");
                    session.token(guestTokenResponse.token());

                    // Challenge
                    log.info("Requesting challenge...");
                    requestService.send(new ChallengeRequest())
                            .exceptionally(throwable -> this.exceptionallyHandler.handle(throwable, ChallengeResponse.class))
                            .thenAccept(challengeResponse -> {
                                if (!challengeResponse.isVerified()) {
                                    future.completeExceptionally(new RuntimeException("Unable to pass challenge! Cause: %s (%s)".formatted(challengeResponse.getError(), challengeResponse.getErrorDescription())));
                                    eventManager.publish(new LoginEvent(LoginEvent.Result.CHALLENGE_FAILED, null));
                                    return;
                                }
                                log.info("Challenge passed!");

                                // Logging in
                                log.info("Logging in...");
                                requestService.send(new OAuthTokenRequest(new OAuthTokenRequest.LoginPayload(challengeResponse.getUuid(), username, password)))
                                        .exceptionally(throwable -> this.exceptionallyHandler.handle(throwable, OAuthTokenResponse.class))
                                        .thenAccept(oAuthTokenResponse -> {
                                            final OAuthToken token = oAuthTokenResponse.token();
                                            if (token == null || !token.isValid()) {
                                                future.completeExceptionally(new RuntimeException("Unable to login! Cause: %s (%s)".formatted(oAuthTokenResponse.getError(), oAuthTokenResponse.getErrorDescription())));
                                                eventManager.publish(new LoginEvent(LoginEvent.Result.FAILURE, null));
                                                return;
                                            }
                                            session.token(token);
                                            log.info("Logged in!");

                                            // Current user details
                                            log.info("Requesting user details...");
                                            requestService.send(new UserInformationRequest())
                                                    .exceptionally(throwable -> this.exceptionallyHandler.handle(throwable, UserInformationResponse.class))
                                                    .thenAccept(userInformationResponse -> {
                                                        final User user = userInformationResponse.getUser();
                                                        if (user == null) {
                                                            future.completeExceptionally(new RuntimeException("Unable to get user details! Cause: %s (%s)".formatted(userInformationResponse.getError(), userInformationResponse.getErrorDescription())));
                                                            eventManager.publish(new LoginEvent(LoginEvent.Result.FAILURE, null));
                                                            return;
                                                        }
                                                        session.user(user);
                                                        eventManager.publish(new LoginEvent(LoginEvent.Result.SUCCESS, token));
                                                        log.info("Logged in as {}!", user.getUsername());
                                                        future.complete(session.user());
                                                    });
                                        });
                            });
                });

        return future;
    }

    /**
     * Logout from the current session.
     *
     * @return A {@link CompletableFuture} that will be completed when the logout is done.
     */
    public CompletableFuture<Boolean> logout() {
        if (!session.loggedIn()) {
            log.warn("You are not logged in!");
            return CompletableFuture.completedFuture(false);
        }
        log.info("Logging out...");
        return requestService.send(new LogoutRequest())
                .thenApply(vintedResponse -> {
                    session.user(null);
                    log.info("Logged out!");
                    eventManager.publish(new LogoutEvent());
                    return true;
                });
    }

    @Accessors(fluent = true)
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Builder {

        private String username;
        private String password;
        private OkHttpClient httpClient;
        private AndroidDevice device;

        /**
         * Build a new {@link VintedAPI} instance.
         *
         * @return A new {@link VintedAPI} instance.
         */
        public VintedAPI build() {
            Objects.requireNonNull(username, "Username cannot be null");
            Objects.requireNonNull(password, "Password cannot be null");

            return new VintedAPI(username,
                    password,
                    Optional.ofNullable(httpClient).orElseGet(() -> VintedUtils.defaultHttpClientBuilder().build()),
                    Optional.ofNullable(device).orElseGet(() -> AndroidDevice.GOOD_DEVICES[0]));
        }
    }

}
