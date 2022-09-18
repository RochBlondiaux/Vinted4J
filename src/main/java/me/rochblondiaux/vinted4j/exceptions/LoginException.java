package me.rochblondiaux.vinted4j.exceptions;

import lombok.Getter;
import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.model.http.response.authentification.OAuthTokenResponse;

@Getter
public class LoginException extends VintedResponseException {
    private final VintedAPI client;
    private final OAuthTokenResponse loginResponse;


    public LoginException(VintedAPI api, OAuthTokenResponse body) {
        super(body);
        this.client = api;
        this.loginResponse = body;
    }
}