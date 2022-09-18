package me.rochblondiaux.vinted4j.factory.request;

import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.VintedConstants;
import me.rochblondiaux.vinted4j.model.device.AndroidDevice;
import me.rochblondiaux.vinted4j.model.http.request.PayloadRequest;
import me.rochblondiaux.vinted4j.model.http.request.VintedRequest;
import me.rochblondiaux.vinted4j.model.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.model.session.OAuthToken;
import me.rochblondiaux.vinted4j.model.session.VintedSession;
import okhttp3.Request;

import java.time.Instant;
import java.util.Optional;

public interface RequestFactory<R extends VintedResponse, T extends VintedRequest<R>> {

    /**
     * Create a {@link Request} from a {@link VintedRequest}.
     *
     * @param api     The {@link VintedAPI} instance.
     * @param request The {@link VintedRequest} to use.
     * @return The {@link Request}.
     */
    Request create(VintedAPI api, T request);

    /**
     * Add default headers to the request.
     *
     * @param api     The {@link VintedAPI} instance.
     * @param builder The request builder.
     * @return The request builder.
     */
    default Request.Builder addDefaultHeader(VintedAPI api, Request.Builder builder) {
        final AndroidDevice device = api.getDevice();
        final VintedSession session = api.getSession();

        Optional.ofNullable(session.token())
                .filter(token -> !token.isExpired())
                .map(OAuthToken::bearerToken)
                .ifPresent(token -> builder.addHeader("Authorization", token));

        return builder.addHeader("Connection", "keep-alive")
                .addHeader("User-Agent", device.getUserAgent())
                .addHeader("x-device-model", "%s %s".formatted(device.getManufacturer(), device.getModel()))
                .addHeader("x-os-version", device.getAndroidVersion())
                .addHeader("x-platform", "android")
                .addHeader("x-screen-height", device.getHeight())
                .addHeader("x-screen-width", device.getWidth())
                .addHeader("x-portal", "fr")
                .addHeader("x-device-uuid", session.deviceId())
                .addHeader("x-anon-id", session.anonymousId())
                .addHeader("x-local-time", String.valueOf(Instant.now().getEpochSecond()))
                .addHeader("x-app-version", VintedConstants.APP_VERSION);
    }


    RequestFactory BASIC = new BasicRequestFactory();
    RequestFactory PAYLOAD = new PayloadRequestFactory();

    static Request make(VintedAPI api, VintedRequest<?> request) {
        if (request instanceof PayloadRequest<?>)
            return PAYLOAD.create(api, request);
        return BASIC.create(api, request);
    }
}