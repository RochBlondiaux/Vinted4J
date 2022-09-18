package me.rochblondiaux.vinted4j.http.response.authentification;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import me.rochblondiaux.vinted4j.http.response.VintedResponse;

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
}
