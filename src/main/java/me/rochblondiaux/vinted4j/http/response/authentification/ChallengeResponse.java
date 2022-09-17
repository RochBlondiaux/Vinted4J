package me.rochblondiaux.vinted4j.http.response.authentification;

import lombok.Getter;
import me.rochblondiaux.vinted4j.http.response.VintedResponse;

@Getter
public class ChallengeResponse extends VintedResponse {

    private String uuid;
    private boolean verified;
    private int code;

}
