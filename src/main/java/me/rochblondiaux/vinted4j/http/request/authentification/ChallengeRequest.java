package me.rochblondiaux.vinted4j.http.request.authentification;

import lombok.Data;
import lombok.NonNull;
import me.rochblondiaux.vinted4j.VintedClient;
import me.rochblondiaux.vinted4j.http.request.PostRequest;
import me.rochblondiaux.vinted4j.http.response.authentification.ChallengeResponse;
import me.rochblondiaux.vinted4j.model.VintedBaseModel;

import java.util.Map;

public class ChallengeRequest extends PostRequest<ChallengeResponse> {

    @Override
    public VintedBaseModel getPayload(VintedClient client) {
        return new ChallengePayload("login", Map.of("username", client.getUsername(), "password", client.getPassword()));
    }

    @Override
    public boolean isEncoded() {
        return false;
    }

    @Override
    public String endpoint() {
        return "captchas";
    }

    @Override
    public Class<ChallengeResponse> responseType() {
        return ChallengeResponse.class;
    }

    @Data
    private static class ChallengePayload extends VintedBaseModel {

        @NonNull
        private String entity_type;
        @NonNull
        private Map<String, String> payload;
    }
}
