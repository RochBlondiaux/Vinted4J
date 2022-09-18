package me.rochblondiaux.vinted4j.factory.request;

import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.model.http.request.VintedRequest;
import me.rochblondiaux.vinted4j.model.http.response.VintedResponse;
import okhttp3.Request;

public class BasicRequestFactory<R extends VintedResponse, T extends VintedRequest<R>> implements RequestFactory<R, T> {

    @Override
    public Request create(VintedAPI api, T request) {
        Request.Builder builder = new Request.Builder()
                .url(request.url(api))
                .get();

        return addDefaultHeader(api, builder).build();
    }
}