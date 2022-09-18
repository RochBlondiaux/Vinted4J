package me.rochblondiaux.vinted4j.model.events.session;

import com.github.philippheuer.events4j.core.domain.Event;
import lombok.Getter;
import me.rochblondiaux.vinted4j.model.session.OAuthToken;

@Getter
public class OAuthTokenRefreshEvent extends Event {

    private final OAuthToken oldToken;
    private final OAuthToken newToken;
    private final long time;
    private final boolean succeed;

    public OAuthTokenRefreshEvent(OAuthToken oldToken, OAuthToken newToken) {
        this.oldToken = oldToken;
        this.newToken = newToken;
        this.time = System.currentTimeMillis();
        this.succeed = true;
    }

    public OAuthTokenRefreshEvent() {
        this.succeed = false;
        this.time = System.currentTimeMillis();
        this.oldToken = null;
        this.newToken = null;
    }
}
