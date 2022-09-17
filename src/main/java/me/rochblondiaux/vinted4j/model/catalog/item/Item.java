package me.rochblondiaux.vinted4j.model.catalog.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import me.rochblondiaux.vinted4j.model.catalog.search.SearchTrackingParams;
import me.rochblondiaux.vinted4j.model.user.Discount;
import me.rochblondiaux.vinted4j.model.user.Photo;
import me.rochblondiaux.vinted4j.model.user.User;

@Data
public class Item {

    private long id;
    private String title;
    private String price;
    private Discount discount;
    private String currency;
    @JsonProperty("brand_title")
    private String brandTitle;
    @JsonProperty("is_for_swap")
    private boolean forSwap;
    private User user;
    private String url;
    private boolean promoted;
    private Photo photo;
    @JsonProperty("favourite_count")
    private int favouriteCount;
    @JsonProperty("is_favourite")
    private boolean favourite;
    @JsonProperty("favourite_group_id")
    private Object favouriteGroupId;
    private Object badge;
    private Object conversion;
    @JsonProperty("service_fee")
    private Object serviceFee;
    @JsonProperty("shipping_fee")
    private Object shippingFee;
    @JsonProperty("total_item_price")
    private String totalItemPrice;
    @JsonProperty("view_count")
    private int views;
    @JsonProperty("size_title")
    private String size;
    @JsonProperty("content_source")
    private String contentSource;
    @JsonProperty("search_tracking_params")
    private SearchTrackingParams searchTrackingParams;
}
