package me.rochblondiaux.vinted4j.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Balance {

    @JsonProperty("available_amount")
    private double amount;
    @JsonProperty("escrow_amount")
    private double escrowAmount;
    private String currency;
}
