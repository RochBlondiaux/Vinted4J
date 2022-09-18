package me.rochblondiaux.vinted4j.model.http.request.user;

import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.model.http.request.method.GETRequest;
import me.rochblondiaux.vinted4j.model.http.response.user.UserInformationResponse;

public record UserProfileRequest(long id) implements GETRequest<UserInformationResponse> {

    @Override
    public String endpoint(VintedAPI client) {
        return "users/%d".formatted(id);
    }

    @Override
    public Class<UserInformationResponse> responseType() {
        return UserInformationResponse.class;
    }
}
