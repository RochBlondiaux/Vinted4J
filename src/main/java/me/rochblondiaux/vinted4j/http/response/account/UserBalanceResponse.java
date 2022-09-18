package me.rochblondiaux.vinted4j.http.response.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import me.rochblondiaux.vinted4j.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.model.user.Balance;

@Data
public class UserBalanceResponse extends VintedResponse {

    @JsonProperty("user_balance")
    private Balance balance;
}
