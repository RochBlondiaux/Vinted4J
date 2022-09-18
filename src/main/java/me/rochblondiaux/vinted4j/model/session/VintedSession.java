package me.rochblondiaux.vinted4j.model.session;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import me.rochblondiaux.vinted4j.model.user.User;
import me.rochblondiaux.vinted4j.utils.VintedUtils;

@Getter
@Accessors(fluent = true)
public class VintedSession {

    @Setter
    private volatile OAuthToken token;
    private String deviceId;
    @Setter
    private String anonymousId;
    private volatile User user;
    private boolean loggedIn;

    public VintedSession(String username, String password) {
        this.anonymousId = VintedUtils.randomUuid();
        this.deviceId = VintedUtils.generateDeviceId(username, password);
    }

    public boolean hasToken() {
        return token != null;
    }

    public boolean hasUser() {
        return user != null;
    }

    public void user(User user) {
        this.user = user;
        this.loggedIn = user != null;
    }
}
