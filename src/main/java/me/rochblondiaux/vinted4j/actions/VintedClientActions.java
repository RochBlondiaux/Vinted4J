package me.rochblondiaux.vinted4j.actions;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;
import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.actions.message.MessageAction;
import me.rochblondiaux.vinted4j.actions.user.UsersAction;

import java.lang.reflect.Field;

@Accessors(fluent = true, prefix = "_")
@Getter
public class VintedClientActions {

    private UsersAction _users;
    private MessageAction _messages;

    @SneakyThrows
    public VintedClientActions(VintedAPI api) {
        for (Field field : this.getClass().getDeclaredFields())
            if (field.getName().startsWith("_"))
                field.set(this, field.getType().getConstructor(VintedAPI.class).newInstance(api));
    }
}
