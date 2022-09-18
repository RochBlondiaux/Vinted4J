package me.rochblondiaux.vinted4j.http.request.inbox;

import lombok.RequiredArgsConstructor;
import me.rochblondiaux.vinted4j.VintedClient;
import me.rochblondiaux.vinted4j.http.request.GetRequest;
import me.rochblondiaux.vinted4j.http.response.inbox.ViewConversationResponse;

@RequiredArgsConstructor
public class ViewConversationRequest extends GetRequest<ViewConversationResponse> {

    private final long conversationId;

    @Override
    public String endpoint(VintedClient client) {
        return "conversations/%d".formatted(conversationId);
    }

    @Override
    public Class<ViewConversationResponse> responseType() {
        return ViewConversationResponse.class;
    }
}
