package me.rochblondiaux.vinted4j.factory;

import me.rochblondiaux.vinted4j.VintedClient;
import me.rochblondiaux.vinted4j.VintedConstants;
import me.rochblondiaux.vinted4j.http.request.VintedRequest;
import me.rochblondiaux.vinted4j.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.model.device.AndroidDevice;
import okhttp3.Request;

public interface RequestFactory<R extends VintedResponse, T extends VintedRequest<R>> {

    Request create(VintedClient client, T request);

    default Request.Builder addDefaultHeader(VintedClient client, Request.Builder builder) {
        final AndroidDevice device = client.getDevice();

        return builder.addHeader("Connection", "keep-alive")
                .addHeader("User-Agent", device.getUserAgent())
                .addHeader("x-device-model", "%s %s".formatted(device.getManufacturer(), device.getModel()))
                .addHeader("x-os-version", device.getAndroidVersion())
                .addHeader("x-platform", "android")
                .addHeader("x-screen-height", device.getHeight())
                .addHeader("x-screen-width", device.getWidth())
                .addHeader("x-portal", "fr")
                .addHeader("x-device-uuid", client.getDeviceId())
                .addHeader("x-anon-id", client.getAnonId())
                .addHeader("x-local-time", String.valueOf(System.currentTimeMillis()))
                .addHeader("x-app-version", VintedConstants.APP_VERSION);
    }
}
