package me.rochblondiaux.vinted4j.model.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import me.rochblondiaux.vinted4j.model.catalog.Brand;
import me.rochblondiaux.vinted4j.model.user.PaymentMethod;
import me.rochblondiaux.vinted4j.model.user.Photo;
import me.rochblondiaux.vinted4j.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Data
public class Item {

    private long id;
    private String title;
    @JsonProperty("brand_id")
    private int brandId;
    @JsonProperty("size_id")
    private int sizeId;
    @JsonProperty("status_id")
    private int statusId;
    @JsonProperty("disposal_conditions")
    private int disposalConditions;
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("owner_id")
    private Object ownerId;
    @JsonProperty("country_id")
    private int countryId;
    @JsonProperty("catalog_id")
    private int catalogId;
    @JsonProperty("color1_id")
    private int color1Id;
    @JsonProperty("color2_id")
    private int color2Id;
    @JsonProperty("package_size_id")
    private int packageSizeId;
    @JsonProperty("is_hidden")
    private boolean hidden;
    @JsonProperty("is_reserved")
    private boolean reserved;
    @JsonProperty("reserved_for_user_id")
    private Object reservedForUserId;
    @JsonProperty("is_visible")
    private boolean visible;
    @JsonProperty("is_unisex")
    private boolean unisex;
    @JsonProperty("is_closed")
    private boolean closed;
    @JsonProperty("is_admin_alerted")
    private boolean adminAlerted;
    @JsonProperty("active_bid_count")
    private int activeBids;
    @JsonProperty("favourite_count")
    private int favourites;
    @JsonProperty("view_count")
    private int views;
    @JsonProperty("moderation_status")
    private int moderationStatus;
    @JsonProperty("last_push_up_at")
    private Date lastPushUpAt;
    private String description;
    @JsonProperty("package_size_standard")
    private boolean standardPackageSize;
    @JsonProperty("item_closing_action")
    private Object itemClosingAction;
    @JsonProperty("related_catalog_ids")
    private List<Long> relatedCatalogIds = new ArrayList<>();
    @JsonProperty("related_catalogs_enabled")
    private boolean relatedCatalogsEnabled;
    private String size;
    @JsonProperty("brand")
    private String brandName;
    private String composition;
    @JsonProperty("extra_conditions")
    private String extraConditions;
    @JsonProperty("is_for_sell")
    private boolean forSell;
    @JsonProperty("is_for_swap")
    private boolean forSwap;
    @JsonProperty("is_for_give_away")
    private boolean forGiveAway;
    @JsonProperty("is_handicraft")
    private boolean handicraft;
    @JsonProperty("is_draft")
    private boolean draft;
    private String label;
    @JsonProperty("real_value_numeric")
    private Object realValueNumeric;
    @JsonProperty("original_price_numeric")
    private String originalPriceNumeric;
    private String currency;
    @JsonProperty("price_numeric")
    private String priceNumeric;
    @JsonProperty("created_at_ts")
    private Date createdAt;
    @JsonProperty("updated_at_ts")
    private Date updatedAt;
    @JsonProperty("user_updated_at_ts")
    private Date userUpdatedAt;
    private List<Photo> photos = new ArrayList<>();
    @JsonProperty("push_up_interval")
    private int pushUpInterval;
    @JsonProperty("can_be_sold")
    private boolean canBeSold;
    @JsonProperty("can_feedback")
    private boolean feedbackAvailable;
    private String path;
    @JsonProperty("possible_to_request_reservation")
    private boolean reservationRequestAvailable;
    @JsonProperty("item_reservation_id")
    private long itemReservationId;
    @JsonProperty("receiver_id")
    private long receiverId;
    @JsonProperty("promoted_until")
    private Object promotedUntil;
    @JsonProperty("discount_price_numeric")
    private Object discountPriceNumeric;
    @JsonProperty("reservation_requests_from_users")
    private List<Object> reservationRequestsFromUsers = new ArrayList<>();
    @JsonProperty("material_id")
    private Object materialId;
    private Object author;
    @JsonProperty("book_title")
    private Object bookTitle;
    private Object isbn;
    @JsonProperty("measurement_width")
    private Object measurementWidth;
    @JsonProperty("measurement_length")
    private Object measurementLength;
    @JsonProperty("transaction_permitted")
    private boolean transactionPermitted;
    @JsonProperty("video_game_rating_id")
    private Object videoGameRatingId;
    private User user;
    @JsonProperty("service_fee")
    private Object serviceFee;
    @JsonProperty("shipping_fee")
    private Object shippingFee;
    @JsonProperty("total_item_price")
    private String totalItemPrice;
    private String price;
    @JsonProperty("discount_price")
    private String discountPrice;
    @JsonProperty("real_value")
    private String realValue;
    @JsonProperty("can_edit")
    private boolean editAvailable;
    @JsonProperty("can_delete")
    private boolean deleteAvailable;
    @JsonProperty("can_request_reservation")
    private boolean canRequestReservation;
    @JsonProperty("can_cancel_reservation_request")
    private boolean canCancelReservationAvailable;
    @JsonProperty("can_reserve")
    private boolean reserveAvailable;
    @JsonProperty("can_transfer")
    private boolean transferAvailable;
    @JsonProperty("instant_buy")
    private boolean instantBuy;
    @JsonProperty("can_close")
    private boolean canClose;
    @JsonProperty("can_buy")
    private boolean canBuy;
    @JsonProperty("can_bundle")
    private boolean canBundle;
    @JsonProperty("can_ask_seller")
    private boolean canAskSeller;
    @JsonProperty("can_favourite")
    private boolean canFavourite;
    @JsonProperty("user_login")
    private String username;
    @JsonProperty("city_id")
    private int cityId;
    private String city;
    private String country;
    private boolean promoted;
    @JsonProperty("is_mobile")
    private boolean mobile;
    @JsonProperty("bump_badge_visible")
    private boolean bumpBadgeVisible;
    @JsonProperty("brand_dto")
    private Brand brand;
    private String url;
    @JsonProperty("accepted_pay_in_methods")
    private List<PaymentMethod> acceptedPayInMethods = new ArrayList<>();
    @JsonProperty("created_at")
    private String createdAt_;
    private String color1;
    private String color2;
    private Object material;
    @JsonProperty("video_game_rating")
    private Object videoGameRating;
    private String status;
    @JsonProperty("is_favourite")
    private boolean favourite;
    @JsonProperty("favourite_group_id")
    private long favouriteGroupId;
    private Object performance;
    @JsonProperty("stats_visible")
    private boolean statsVisible;
    @JsonProperty("can_push_up")
    private boolean canPushUp;
    private Object badge;
    @JsonProperty("size_guide_faq_entry_id")
    private int sizeGuideFaqEntryId;
    private String localization;
    @JsonProperty("free_return_img")
    private String freeReturnImg;
}
