package me.rochblondiaux.vinted4j.model.http.request.user;

import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.model.http.request.method.GETRequest;
import me.rochblondiaux.vinted4j.model.http.response.user.UserInformationResponse;

public class UserInformationRequest implements GETRequest<UserInformationResponse> {

    @Override
    public String endpoint(VintedAPI client) {
        return "users/current";
    }

    @Override
    public Class<UserInformationResponse> responseType() {
        return UserInformationResponse.class;
    }
}
