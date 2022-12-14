package me.rochblondiaux.vinted4j.http.request.account;

import me.rochblondiaux.vinted4j.VintedClient;
import me.rochblondiaux.vinted4j.http.request.GetRequest;
import me.rochblondiaux.vinted4j.http.response.account.UserDetailsResponse;

public class UserDetailsRequest extends GetRequest<UserDetailsResponse> {

    @Override
    public String endpoint(VintedClient client) {
        return "users/current";
    }

    @Override
    public Class<UserDetailsResponse> responseType() {
        return UserDetailsResponse.class;
    }
}
