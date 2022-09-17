package me.rochblondiaux.vinted4j.factory;

import me.rochblondiaux.vinted4j.VintedClient;
import me.rochblondiaux.vinted4j.http.request.PostRequest;
import me.rochblondiaux.vinted4j.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.utils.VintedUtils;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.Optional;
import java.util.stream.Collectors;

public class PostRequestFactory<R extends VintedResponse, T extends PostRequest<R>> implements RequestFactory<R, T> {

    @Override
    public Request create(VintedClient client, T request) {
        final String rawMediaType = request.isEncoded() ? "application/x-www-form-urlencoded" : "application/json";
        final MediaType mediaType = MediaType.parse(rawMediaType);
        final RequestBody body = RequestBody.create(request.isEncoded() ? formatPayload(client, request) : VintedUtils.objectToJson(request.getPayload(client)), mediaType);

        Request.Builder builder = new Request.Builder()
                .url(request.url(client))
                .post(body)
                .addHeader("Content-Type", rawMediaType);

        Optional.ofNullable(client.getToken())
               // .filter(token -> !token.isExpired()) // TODO: fix that shit
                .ifPresent(token -> {
                    builder.addHeader("Authorization", "Bearer %s".formatted(token.getToken()));
                });

        return addDefaultHeader(client, builder).build();
    }

    private String formatPayload(VintedClient client, T request) {
        return VintedUtils.objectToMap(request.getPayload(client))
                .entrySet()
                .stream()
                .map(e -> "%s=%s".formatted(e.getKey(), e.getValue()))
                .collect(Collectors.joining("&"));
    }
}
