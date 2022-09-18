package me.rochblondiaux.vinted4j.http.response.account;

import lombok.Data;
import me.rochblondiaux.vinted4j.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.model.user.UserStats;

@Data
public class UserStatsResponse extends VintedResponse {

    private UserStats stats;
}
