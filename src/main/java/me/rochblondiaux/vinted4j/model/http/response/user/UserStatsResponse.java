package me.rochblondiaux.vinted4j.model.http.response.user;

import lombok.Data;
import me.rochblondiaux.vinted4j.model.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.model.vinted.user.UserStats;

@Data
public class UserStatsResponse extends VintedResponse {

    private UserStats stats;

}
