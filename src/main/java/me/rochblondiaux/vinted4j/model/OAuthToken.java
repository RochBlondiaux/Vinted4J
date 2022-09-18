package me.rochblondiaux.vinted4j.model;

import lombok.Data;
import lombok.NonNull;
import me.rochblondiaux.vinted4j.http.response.authentification.OAuthTokenResponse;

import java.time.Instant;

@Data
public class OAuthToken {

    private final String token;
    private final String tokenType;
    private final String refreshToken;
    private final String scope;
    private final long expiresIn;
    private final long createdAt;

    public OAuthToken(@NonNull OAuthTokenResponse response) {
        this.token = response.getAccessToken();
        this.tokenType = response.getTokenType();
        this.refreshToken = response.getRefreshToken();
        this.scope = response.getScope();
        this.expiresIn = response.getExpiresIn();
        this.createdAt = response.getCreatedAt();
    }

    public boolean isExpired() {
        return Instant.now().getEpochSecond() >= (createdAt + expiresIn);
    }
}
