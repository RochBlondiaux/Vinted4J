package me.rochblondiaux.vinted4j.http.response.inbox;

import com.fasterxml.jackson.annotation.JsonProperty;
import me.rochblondiaux.vinted4j.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.model.catalog.search.Pagination;
import me.rochblondiaux.vinted4j.model.inbox.Conversation;

import java.util.List;

public class ListInboxResponse extends VintedResponse {

    private List<Conversation> conversations;
    private Pagination pagination;
    @JsonProperty("websocket_user_id")
    private String websocketUserId;
}
