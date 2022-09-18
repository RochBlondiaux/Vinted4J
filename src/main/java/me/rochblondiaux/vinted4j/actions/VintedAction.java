package me.rochblondiaux.vinted4j.actions;

import com.github.philippheuer.events4j.core.EventManager;
import lombok.experimental.Delegate;
import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.model.session.VintedSession;
import me.rochblondiaux.vinted4j.model.vinted.user.User;
import me.rochblondiaux.vinted4j.service.RequestService;

public class VintedAction {

    protected final VintedAPI api;
    protected final VintedSession session;
    protected final User user;
    protected final EventManager events;
    @Delegate
    protected final RequestService requests;

    public VintedAction(VintedAPI api) {
        this.api = api;
        this.session = api.getSession();
        this.user = session.user();
        this.events = api.getEventManager();
        this.requests = api.getRequestService();
    }


}
