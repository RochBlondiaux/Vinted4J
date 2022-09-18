package me.rochblondiaux.vinted4j.model.market.offer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OfferRequestOptions {

    @JsonProperty("max_discount")
    private String maxDiscount;
    @JsonProperty("min_price")
    private String minPrice;
    @JsonProperty("max_price")
    private String maxPrice;
    private int remaining;
    @JsonProperty("can_make_more")
    private boolean canMakeMore;
    private String currency;
}
