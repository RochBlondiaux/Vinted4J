package me.rochblondiaux.vinted4j.model.http.request.user;

import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.model.http.request.method.GETRequest;
import me.rochblondiaux.vinted4j.model.http.response.user.UserStatsResponse;

public class UserStatsRequest implements GETRequest<UserStatsResponse> {

    @Override
    public String endpoint(VintedAPI client) {
        return "users/%d/stats".formatted(client.getSession().user().getId());
    }

    @Override
    public Class<UserStatsResponse> responseType() {
        return UserStatsResponse.class;
    }
}
