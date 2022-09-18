package me.rochblondiaux.vinted4j.model.events.authentification;

import com.github.philippheuer.events4j.core.domain.Event;
import lombok.Data;
import me.rochblondiaux.vinted4j.model.session.OAuthToken;

@Data
public class LoginEvent extends Event {

    private final Result result;
    private final OAuthToken token;

    public enum Result {
        SUCCESS,
        FAILURE,
        CHALLENGE_FAILED
    }
}
