package me.rochblondiaux.vinted4j.task;

import lombok.extern.log4j.Log4j2;
import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.model.events.session.OAuthTokenRefreshEvent;
import me.rochblondiaux.vinted4j.model.http.request.authentification.OAuthTokenRequest;
import me.rochblondiaux.vinted4j.model.session.OAuthToken;
import me.rochblondiaux.vinted4j.model.session.VintedSession;

import java.util.concurrent.TimeUnit;

@Log4j2
public class OAuthRefreshTask extends RecurrentTask {

    public OAuthRefreshTask(VintedAPI api) {
        super(api, 1, 1, TimeUnit.MINUTES);
    }

    @Override
    public void run() {
        final VintedSession session = api.getSession();
        final OAuthToken token = session.token();

        if (!token.isExpired())
            return;
        log.info("Refreshing OAuth token...");
        api.getRequestService()
                .send(new OAuthTokenRequest(new OAuthTokenRequest.RefreshPayload(token)))
                .thenAccept(response -> {
                    final OAuthToken newToken = response.token();
                    if (newToken == null || !newToken.isValid()) {
                        api.getEventManager().publish(new OAuthTokenRefreshEvent());
                        throw new RuntimeException("Unable to refresh OAuth token!");
                    }
                    log.info("OAuth token refreshed!");
                    api.getEventManager().publish(new OAuthTokenRefreshEvent(token, newToken));
                    session.token(newToken);
                });
    }
}
