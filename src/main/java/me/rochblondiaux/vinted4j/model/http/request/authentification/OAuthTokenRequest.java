package me.rochblondiaux.vinted4j.model.http.request.authentification;

import lombok.*;
import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.model.http.VintedBaseModel;
import me.rochblondiaux.vinted4j.model.http.request.method.POSTRequest;
import me.rochblondiaux.vinted4j.model.http.request.PayloadRequest;
import me.rochblondiaux.vinted4j.model.http.response.authentification.OAuthTokenResponse;

@RequiredArgsConstructor
public class OAuthTokenRequest extends PayloadRequest<OAuthTokenResponse> implements POSTRequest<OAuthTokenResponse> {

    private final GuestPayload payload;

    @Override
    public VintedBaseModel payload(VintedAPI api) {
        return payload;
    }

    @Override
    public boolean isJSON() {
        return payload instanceof LoginPayload;
    }

    @Override
    public String endpoint(VintedAPI client) {
        return "oauth/token";
    }

    @Override
    public String apiPath() {
        return "";
    }

    @Override
    public Class<OAuthTokenResponse> responseType() {
        return OAuthTokenResponse.class;
    }

    @Data
    public static class GuestPayload extends VintedBaseModel {
        @NonNull
        protected String grant_type;
        @NonNull
        protected String client_id;
        @NonNull
        protected String scope;

        public GuestPayload() {
            this.grant_type = "password";
            this.client_id = "android";
            this.scope = "public";
        }
    }

    @Data
    public static class LoginPayload extends GuestPayload {

        @NonNull
        private String uuid;
        @NonNull
        private String username;
        @NonNull
        private String password;

        public LoginPayload(String uuid, String username, String password) {
            this.uuid = uuid;
            this.username = username;
            this.password = password;
            this.scope = "user";
        }
    }
}
