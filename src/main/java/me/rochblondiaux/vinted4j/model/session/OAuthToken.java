package me.rochblondiaux.vinted4j.model.session;

import java.time.Instant;

public record OAuthToken(String token, String tokenType, String refreshToken, String scope, long expiresIn,
                         long createdAt) {

    public boolean isExpired() {
        return Instant.now().getEpochSecond() >= (createdAt + expiresIn);
    }

    public String bearerToken() {
        return token == null || token.isEmpty() ? null : "Bearer %s".formatted(token);
    }

    public boolean isValid() {
        return token != null && !token.isEmpty();
    }
}
