package me.rochblondiaux.vinted4j.model.market.offer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Offer {

    private long id;
    @JsonProperty("transaction_id")
    private long transactionId;
    private String price;
    private String currency;
    @JsonProperty("is_system")
    private boolean system;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("buyer_id")
    private long buyerId;
    @JsonProperty("seller_id")
    private long sellerId;
    @JsonProperty("user_msg_thread_id")
    private long userMsgThreadId;
}
