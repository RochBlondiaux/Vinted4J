package me.rochblondiaux.vinted4j.model.events.authentification;

import com.github.philippheuer.events4j.core.domain.Event;
import lombok.Getter;

@Getter
public class LogoutEvent extends Event {

    private final long time;

    public LogoutEvent() {
        this.time = System.currentTimeMillis();
    }
}
