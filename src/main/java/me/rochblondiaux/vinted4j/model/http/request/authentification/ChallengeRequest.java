package me.rochblondiaux.vinted4j.model.http.request.authentification;

import lombok.Data;
import lombok.NonNull;
import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.model.http.VintedBaseModel;
import me.rochblondiaux.vinted4j.model.http.request.method.POSTRequest;
import me.rochblondiaux.vinted4j.model.http.request.PayloadRequest;
import me.rochblondiaux.vinted4j.model.http.response.authentification.ChallengeResponse;

import java.util.Map;

public class ChallengeRequest extends PayloadRequest<ChallengeResponse> implements POSTRequest<ChallengeResponse> {


    @Override
    public String endpoint(VintedAPI client) {
        return "captchas";
    }

    @Override
    public Class<ChallengeResponse> responseType() {
        return ChallengeResponse.class;
    }

    @Override
    public VintedBaseModel payload(VintedAPI api) {
        return new Payload("login", Map.of("username", api.getUsername(), "password", api.getPassword()));
    }

    @Override
    public boolean isJSON() {
        return true;
    }

    @Data
    private static class Payload extends VintedBaseModel {

        @NonNull
        private String entity_type;
        @NonNull
        private Map<String, String> payload;
    }
}
