package me.rochblondiaux.vinted4j.tasks;

import lombok.extern.log4j.Log4j2;
import me.rochblondiaux.vinted4j.VintedClient;
import me.rochblondiaux.vinted4j.http.request.account.UserDetailsRequest;
import me.rochblondiaux.vinted4j.http.response.account.UserDetailsResponse;

import java.util.concurrent.TimeUnit;

@Log4j2
public class UserDetailsTask extends RecurrentTask {

    public UserDetailsTask(VintedClient client) {
        super(client, 0, 1, TimeUnit.MINUTES);
    }

    @Override
    public void run() {
        client.sendRequest(new UserDetailsRequest())
                .exceptionally(throwable -> client.getExceptionallyHandler().handle(throwable, UserDetailsResponse.class))
                .thenAccept(response -> {
                    client.setUser(response.getUser());
                    log.info("User details updated.");
                });
    }
}
