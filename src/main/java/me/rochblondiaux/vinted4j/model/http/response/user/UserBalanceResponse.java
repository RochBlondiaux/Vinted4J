package me.rochblondiaux.vinted4j.model.http.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import me.rochblondiaux.vinted4j.model.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.model.vinted.user.Balance;

@Data
public class UserBalanceResponse extends VintedResponse {

    @JsonProperty("user_balance")
    private Balance balance;
}
