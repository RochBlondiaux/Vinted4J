package me.rochblondiaux.vinted4j.model.http.response.authentification;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import me.rochblondiaux.vinted4j.model.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.model.session.OAuthToken;

@Getter
public class OAuthTokenResponse extends VintedResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("token_type")
    private String tokenType;
    private String scope;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("expires_in")
    private long expiresIn;
    @JsonProperty("created_at")
    private long createdAt;

    public OAuthToken token() {
        return new OAuthToken(accessToken, tokenType, scope, refreshToken, expiresIn, createdAt);
    }
}