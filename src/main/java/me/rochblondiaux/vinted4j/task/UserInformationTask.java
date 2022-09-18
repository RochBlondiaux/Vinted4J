package me.rochblondiaux.vinted4j.task;

import lombok.extern.log4j.Log4j2;
import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.model.http.request.user.UserInformationRequest;
import me.rochblondiaux.vinted4j.model.http.response.user.UserInformationResponse;

import java.util.concurrent.TimeUnit;

@Log4j2
public class UserInformationTask extends RecurrentTask {

    public UserInformationTask(VintedAPI api) {
        super(api, 0, 5, TimeUnit.MINUTES);
    }

    @Override
    public void run() {
        api.getRequestService()
                .send(new UserInformationRequest())
                .exceptionally(throwable -> api.getExceptionallyHandler().handle(throwable, UserInformationResponse.class))
                .thenAccept(response -> {
                    api.getSession().user(response.getUser());
                    log.info("User information updated.");
                });
    }
}
