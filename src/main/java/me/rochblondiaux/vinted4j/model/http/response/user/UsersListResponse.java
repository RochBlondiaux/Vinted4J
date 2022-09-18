package me.rochblondiaux.vinted4j.model.http.response.user;

import lombok.Data;
import me.rochblondiaux.vinted4j.model.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.model.vinted.user.User;

import java.util.ArrayList;
import java.util.List;

@Data
public class UsersListResponse extends VintedResponse {

    private List<User> users = new ArrayList<>();
}
