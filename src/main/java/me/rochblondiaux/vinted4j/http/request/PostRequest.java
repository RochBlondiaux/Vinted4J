package me.rochblondiaux.vinted4j.http.request;

import lombok.extern.log4j.Log4j2;
import me.rochblondiaux.vinted4j.VintedClient;
import me.rochblondiaux.vinted4j.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.model.VintedBaseModel;

@Log4j2
public abstract class PostRequest<R extends VintedResponse> extends VintedRequest<R> {

    public abstract VintedBaseModel getPayload(VintedClient client);

    public abstract boolean isEncoded();
}
