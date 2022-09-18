package me.rochblondiaux.vinted4j.http.request.inbox;

import lombok.RequiredArgsConstructor;
import me.rochblondiaux.vinted4j.VintedClient;
import me.rochblondiaux.vinted4j.http.request.DeleteRequest;
import me.rochblondiaux.vinted4j.http.response.inbox.ViewConversationResponse;

@RequiredArgsConstructor
public class DeleteMessageRequest extends DeleteRequest<ViewConversationResponse> {

    private final long conversationId;
    private final long messageId;

    @Override
    public String endpoint(VintedClient client) {
        return "conversations/%d/replies/%d".formatted(conversationId, messageId);
    }

    @Override
    public Class<ViewConversationResponse> responseType() {
        return ViewConversationResponse.class;
    }
}
