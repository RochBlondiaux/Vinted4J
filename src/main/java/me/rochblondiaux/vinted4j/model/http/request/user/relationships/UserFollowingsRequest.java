package me.rochblondiaux.vinted4j.model.http.request.user.relationships;

import lombok.Data;
import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.model.http.request.method.GETRequest;
import me.rochblondiaux.vinted4j.model.http.response.user.UsersListResponse;

public record UserFollowingsRequest(long userId, int page, int perPage) implements GETRequest<UsersListResponse> {

    @Override
    public String endpoint(VintedAPI client) {
        return "users/%d/followed_users?page=%d&per_page=%d".formatted(userId, page, perPage);
    }

    @Override
    public Class<UsersListResponse> responseType() {
        return UsersListResponse.class;
    }
}
