package me.rochblondiaux.vinted4j.http.request.inbox;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import me.rochblondiaux.vinted4j.VintedClient;
import me.rochblondiaux.vinted4j.http.request.PostRequest;
import me.rochblondiaux.vinted4j.http.response.inbox.ViewConversationResponse;
import me.rochblondiaux.vinted4j.model.VintedBaseModel;
import me.rochblondiaux.vinted4j.model.inbox.MessageEntity;

@RequiredArgsConstructor
public class SendMessageRequest extends PostRequest<ViewConversationResponse> {

    private final int conversationId;
    private final MessageEntity entity;

    @Override
    public VintedBaseModel getPayload(VintedClient client) {
        return new SendMessagePayload(entity);
    }

    @Override
    public boolean isEncoded() {
        return false;
    }

    @Override
    public String endpoint(VintedClient client) {
        return "conversations/%d/replies".formatted(conversationId);
    }

    @Override
    public Class<ViewConversationResponse> responseType() {
        return ViewConversationResponse.class;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    public static class SendMessagePayload extends VintedBaseModel {

        private MessageEntity reply;

    }
}
