package me.rochblondiaux.vinted4j.model.http.response.authentification;

import lombok.Getter;
import me.rochblondiaux.vinted4j.model.http.response.VintedResponse;

@Getter
public class ChallengeResponse extends VintedResponse {

    private String uuid;
    private boolean verified;
}
