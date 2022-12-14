package me.rochblondiaux.vinted4j.model.http.response.user;

import lombok.Data;
import me.rochblondiaux.vinted4j.model.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.model.vinted.user.User;

@Data
public class UserInformationResponse extends VintedResponse {

    private User user;
}
