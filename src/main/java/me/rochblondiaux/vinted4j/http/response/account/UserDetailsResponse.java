package me.rochblondiaux.vinted4j.http.response.account;

import lombok.Data;
import me.rochblondiaux.vinted4j.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.model.user.User;

@Data
public class UserDetailsResponse extends VintedResponse {

    private User user;
    private int code;
}
