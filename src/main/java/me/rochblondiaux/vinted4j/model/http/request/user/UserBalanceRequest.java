package me.rochblondiaux.vinted4j.model.http.request.user;

import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.model.http.request.method.GETRequest;
import me.rochblondiaux.vinted4j.model.http.response.user.UserBalanceResponse;

public class UserBalanceRequest implements GETRequest<UserBalanceResponse> {

    @Override
    public String endpoint(VintedAPI client) {
        return "users/%d/balance".formatted(client.getSession().user().getId());
    }

    @Override
    public Class<UserBalanceResponse> responseType() {
        return UserBalanceResponse.class;
    }
}
