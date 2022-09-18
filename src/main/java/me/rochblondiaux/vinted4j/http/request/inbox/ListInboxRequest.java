package me.rochblondiaux.vinted4j.http.request.inbox;

import me.rochblondiaux.vinted4j.VintedClient;
import me.rochblondiaux.vinted4j.http.request.GetRequest;
import me.rochblondiaux.vinted4j.http.response.inbox.ListInboxResponse;

public class ListInboxRequest extends GetRequest<ListInboxResponse> {

    @Override
    public String endpoint(VintedClient client) {
        return "inbox?page=1&per_page=20"; // TODO: make it dynamic
    }

    @Override
    public Class<ListInboxResponse> responseType() {
        return ListInboxResponse.class;
    }
}
