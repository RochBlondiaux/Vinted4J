package me.rochblondiaux.vinted4j.model.http.request.method;

import me.rochblondiaux.vinted4j.model.http.request.VintedRequest;
import me.rochblondiaux.vinted4j.model.http.response.VintedResponse;

public interface PUTRequest<R extends VintedResponse> extends VintedRequest<R> {

    @Override
    default String method() {
        return "PUT";
    }
}
