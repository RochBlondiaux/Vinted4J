package me.rochblondiaux.vinted4j.http.request.account;

import me.rochblondiaux.vinted4j.VintedClient;
import me.rochblondiaux.vinted4j.http.request.GetRequest;
import me.rochblondiaux.vinted4j.http.response.account.UserStatsResponse;

public class UserStatsRequest extends GetRequest<UserStatsResponse> {
    @Override
    public String endpoint(VintedClient client) {
        return "users/%d/stats".formatted(client.getUser().getId());
    }

    @Override
    public Class<UserStatsResponse> responseType() {
        return UserStatsResponse.class;
    }
}
