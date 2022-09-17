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
    @JsonProperty("expiresIn")
    private long expiresIn;
    @JsonProperty("created_at")
    private long createdAt;

    /* Error */
    private String error;
    @JsonProperty("error_description")
    private String errorDescription;
    private int code;
    private String message;


    public void print() {
        System.out.println("==================================");
        System.out.println("access_token: " + accessToken);
        System.out.println("token_type: " + tokenType);
        System.out.println("scope: " + scope);
        System.out.println("refresh_token: " + refreshToken);
        System.out.println("expiresIn: " + expiresIn);
        System.out.println("created_at: " + createdAt);
        System.out.println("==================================\n\n");
    }

}
