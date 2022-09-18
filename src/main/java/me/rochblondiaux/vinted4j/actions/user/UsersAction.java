package me.rochblondiaux.vinted4j.actions.user;

import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.actions.VintedAction;
import me.rochblondiaux.vinted4j.model.http.request.user.UserProfileRequest;
import me.rochblondiaux.vinted4j.model.vinted.user.User;

import java.util.concurrent.CompletableFuture;

@Log4j2
public class UsersAction extends VintedAction {

    public UsersAction(VintedAPI api) {
        super(api);
    }

    public UserAction user(@NonNull User user) {
        return new UserAction(api, user);
    }

    public CompletableFuture<UserAction> user(long id) {
        return findById(id).thenApply(this::user);
    }

    public CompletableFuture<User> findById(long id) {
        log.info("Getting user with id {}", id);
        return send(new UserProfileRequest(id))
                .exceptionally(throwable -> {
                    log.error("Failed to get user with id %s".formatted(id), throwable);
                    return null;
                })
                .thenApply(userInformationResponse -> {
                    final User usr = userInformationResponse.getUser();
                    if (usr == null)
                        throw new RuntimeException("Failed to get user with id %s".formatted(id));
                    return usr;
                });
    }

}
