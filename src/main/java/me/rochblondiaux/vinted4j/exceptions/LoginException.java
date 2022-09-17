package me.rochblondiaux.vinted4j.exceptions;

import lombok.Getter;
import me.rochblondiaux.vinted4j.VintedClient;
import me.rochblondiaux.vinted4j.http.response.authentification.OAuthTokenResponse;

@Getter
public class LoginException extends VintedResponseException {
    private final VintedClient client;
    private final OAuthTokenResponse loginResponse;


    public LoginException(VintedClient client, OAuthTokenResponse body) {
        super(body);
        this.client = client;
        this.loginResponse = body;
    }
}