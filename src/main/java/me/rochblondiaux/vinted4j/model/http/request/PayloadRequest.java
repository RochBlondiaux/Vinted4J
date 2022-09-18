package me.rochblondiaux.vinted4j.model.http.request;

import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.model.http.VintedBaseModel;
import me.rochblondiaux.vinted4j.model.http.response.VintedResponse;

public abstract class PayloadRequest<R extends VintedResponse> implements VintedRequest<R> {

    /**
     * The body of the request.
     *
     * @param api The API instance.
     * @return The body of the request.
     */
    public abstract VintedBaseModel payload(VintedAPI api);

    /**
     * Checks if the body should be sent as JSON or as form data.
     *
     * @return True if the body should be sent as JSON, false if it should be sent as form data.
     */
    public abstract boolean isJSON();
}
