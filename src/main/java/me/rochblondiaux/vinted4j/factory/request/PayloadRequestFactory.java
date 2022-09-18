package me.rochblondiaux.vinted4j.factory.request;

import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.model.http.request.PayloadRequest;
import me.rochblondiaux.vinted4j.model.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.utils.VintedUtils;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.stream.Collectors;

public class PayloadRequestFactory<R extends VintedResponse, T extends PayloadRequest<R>> implements RequestFactory<R, T> {

    @Override
    public Request create(VintedAPI api, T request) {
        final String rawMediaType = request.isJSON() ? "application/json" : "application/x-www-form-urlencoded";
        final MediaType mediaType = MediaType.parse(rawMediaType);
        final RequestBody body = RequestBody.create(request.isJSON() ? VintedUtils.objectToJson(request.payload(api)) : formatPayload(api, request), mediaType);

        Request.Builder builder = new Request.Builder()
                .url(request.url(api))
                .method(request.method(), body)
                .addHeader("Content-Type", rawMediaType);

        return addDefaultHeader(api, builder).build();
    }

    private String formatPayload(VintedAPI client, T request) {
        return VintedUtils.objectToMap(request.payload(client))
                .entrySet()
                .stream()
                .map(e -> "%s=%s".formatted(e.getKey(), e.getValue()))
                .collect(Collectors.joining("&"));
    }
}
