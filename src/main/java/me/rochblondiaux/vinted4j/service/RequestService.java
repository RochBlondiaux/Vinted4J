package me.rochblondiaux.vinted4j.service;

import kotlin.Pair;
import lombok.extern.log4j.Log4j2;
import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.factory.request.RequestFactory;
import me.rochblondiaux.vinted4j.factory.response.ResponseFactory;
import me.rochblondiaux.vinted4j.model.http.request.VintedRequest;
import me.rochblondiaux.vinted4j.model.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.utils.VintedUtils;
import okhttp3.*;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Log4j2
public record RequestService(VintedAPI api) {

    public <R extends VintedResponse, T extends VintedRequest<R>> CompletableFuture<R> send(T request) {
        final CompletableFuture<Pair<Response, String>> responseFuture = new CompletableFuture<>();

        log.info("Sending request : {}", request.url(api));
        api.getHttpClient().newCall(RequestFactory.make(api, request))
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
                    return new ResponseFactory<>(request, api).make(res);
                });
    }

    private static String bodyToString(final Request request) {

        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            Objects.requireNonNull(copy.body()).writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }
}
