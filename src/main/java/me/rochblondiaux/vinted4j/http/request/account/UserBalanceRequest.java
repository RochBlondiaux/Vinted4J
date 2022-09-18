package me.rochblondiaux.vinted4j.http.request.account;

import me.rochblondiaux.vinted4j.VintedClient;
import me.rochblondiaux.vinted4j.http.request.GetRequest;
import me.rochblondiaux.vinted4j.http.response.account.UserBalanceResponse;

public class UserBalanceRequest extends GetRequest<UserBalanceResponse> {

    @Override
    public String endpoint(VintedClient client) {
        return "users/%d/balance".formatted(client.getUser().getId());
    }

    @Override
    public Class<UserBalanceResponse> responseType() {
        return UserBalanceResponse.class;
    }
}
