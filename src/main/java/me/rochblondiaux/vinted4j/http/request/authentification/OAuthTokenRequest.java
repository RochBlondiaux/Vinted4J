package me.rochblondiaux.vinted4j.http.request.authentification;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import me.rochblondiaux.vinted4j.VintedClient;
import me.rochblondiaux.vinted4j.http.request.PostRequest;
import me.rochblondiaux.vinted4j.http.response.authentification.OAuthTokenResponse;
import me.rochblondiaux.vinted4j.model.VintedBaseModel;

@RequiredArgsConstructor
public class OAuthTokenRequest extends PostRequest<OAuthTokenResponse> {

    private final OAuthTokenPayload payload;

    @Override
    public String endpoint() {
        return "oauth/token";
    }

    @Override
    public Class<OAuthTokenResponse> responseType() {
        return OAuthTokenResponse.class;
    }

    @Override
    public String apiPath() {
        return "";
    }

    @Override
    public VintedBaseModel getPayload(VintedClient client) {
        return payload;
    }

    @Override
    public boolean isEncoded() {
        return !(payload instanceof LoginTokenPayload);
    }

    @Data
    public static class OAuthTokenPayload extends VintedBaseModel {

        @NonNull
        protected String grant_type;
        @NonNull
        protected String client_id;
        @NonNull
        protected String scope;

        public OAuthTokenPayload() {
            this.grant_type = "password";
            this.client_id = "android";
            this.scope = "public";
        }
    }

    @Data
    public static class LoginTokenPayload extends OAuthTokenPayload {

        @NonNull
        private String uuid;
        @NonNull
        private String username;
        @NonNull
        private String password;

        public LoginTokenPayload(String uuid, String username, String password) {
            this.uuid = uuid;
            this.username = username;
            this.password = password;
            this.scope = "user";
        }
    }
}
