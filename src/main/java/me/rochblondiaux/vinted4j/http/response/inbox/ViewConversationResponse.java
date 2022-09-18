package me.rochblondiaux.vinted4j.http.response.inbox;

import lombok.Data;
import me.rochblondiaux.vinted4j.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.model.inbox.Conversation;

@Data
public class ViewConversationResponse extends VintedResponse {

    private Conversation conversation;

}
