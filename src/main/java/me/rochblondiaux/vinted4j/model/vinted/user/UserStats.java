package me.rochblondiaux.vinted4j.model.vinted.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserStats {

    @JsonProperty("unread_msg_count")
    private int unreadMsg;
    @JsonProperty("unread_private_msg_count")
    private int unreadPrivateMsg;
    @JsonProperty("unread_notification_count")
    private int unreadNotification;
    @JsonProperty("item_count")
    private int items;
    @JsonProperty("wallet_balance")
    private double balance;
    @JsonProperty("wallet_balance_currency")
    private String currency;
    @JsonProperty("free_push_ups_count")
    private int freePushUps;
    @JsonProperty("promoted_closet")
    private boolean promotedCloset;
    @JsonProperty("promoted_closet_ends_in_days")
    private int promotedClosetEndsInDays;
    @JsonProperty("can_make_offers")
    private boolean canMakeOffers;
}
