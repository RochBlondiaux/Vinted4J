package me.rochblondiaux.vinted4j.model.events.authentification;

import com.github.philippheuer.events4j.core.domain.Event;
import lombok.Data;

@Data
public class PreLoginEvent extends Event {

    private final String username;
    private final String password;

}
