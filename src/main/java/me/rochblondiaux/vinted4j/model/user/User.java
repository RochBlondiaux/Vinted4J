package me.rochblondiaux.vinted4j.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import okhttp3.Address;

import java.util.ArrayList;
import java.util.Date;

@Data
public class User {

    private long id;

    // Personal information
    @JsonProperty("anon_id")
    private String anonymousId;
    @JsonProperty("login")
    private String username;
    @JsonProperty("real_name")
    private String fullName;
    private String email;
    private String gender;
    private Date birthday;
    private String currency;

    // Permissions
    @JsonProperty("real_name_permission")
    private int realNamePermission;
    @JsonProperty("birthday_permission")
    private int birthdayPermission;

    // Items
    @JsonProperty("item_count")
    private int itemCount;
    @JsonProperty("msg_template_count")
    private int msgTemplate;
    @JsonProperty("given_item_count")
    private int givenItem;
    @JsonProperty("taken_item_count")
    private int takenItem;

    // Forum
    @JsonProperty("favourite_topic_count")
    private int favouriteTopic;
    @JsonProperty("forum_msg_count")
    private int forumMsg;
    @JsonProperty("forum_topic_count")
    private int forumTopic;

    // Relationships
    @JsonProperty("followers_count")
    private int followers;
    @JsonProperty("following_count")
    private int following;
    @JsonProperty("following_brands_count")
    private int followingBrands;

    // Feedbacks
    @JsonProperty("positive_feedback_count")
    private int positiveFeedback;
    @JsonProperty("neutral_feedback_count")
    private int neutralFeedback;
    @JsonProperty("negative_feedback_count")
    private int negativeFeedback;

    @JsonProperty("meeting_transaction_count")
    private int meetingTransaction;
    @JsonProperty("account_status")
    private int status;
    @JsonProperty("email_bounces")
    private Object emailBounces;
    @JsonProperty("feedbackReputation")
    private int feedback_reputation;
    @JsonProperty("account_ban_date")
    private Date banDate;

    // Banishment
    @JsonProperty("is_account_ban_permanent")
    private boolean banPermanently;
    @JsonProperty("is_forum_ban_permanent")
    private boolean forumBanPermanently;

    @JsonProperty("is_on_holiday")
    private boolean onHoliday;
    @JsonProperty("is_publish_photos_agreed")
    private boolean publishPhotosAgreed;
    @JsonProperty("is_login_via_external_system_only")
    private boolean loginViaExternalSystemOnly;
    @JsonProperty("use_sizes_in_feed")
    private boolean sizesInFeed;
    @JsonProperty("allow_my_favourite_notifications")
    private boolean allowMyFavouriteNotificationsEnabled;
    @JsonProperty("allow_personalization")
    private boolean allowPersonalizationEnabled;
    private boolean undiscoverable;
    @JsonProperty("accepts_payments")
    private boolean acceptsPayments;
    @JsonProperty("is_location_private")
    private boolean locationPrivate;
    @JsonProperty("expose_location")
    private boolean locationExposed;
    @JsonProperty("third_party_tracking")
    private boolean thirdPartyTrackingEnabled;
    @JsonProperty("default_address")
    private Address defaultAddress;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("last_loged_on_ts")
    private Date lastLoggedOn;
    @JsonProperty("city_id")
    private int cityId;
    private String city;
    @JsonProperty("country_id")
    private int countryId;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("countryIsoCode")
    private String country_iso_code;
    @JsonProperty("country_title_local")
    private String countryTitleLocal;
    @JsonProperty("country_title")
    private String countryTitle;
    @JsonProperty("contacts_permission")
    private Object contactsPermission;
    private Object contacts;
    //    private Photo photo;
    private String path;
    @JsonProperty("is_god")
    private boolean god;
    @JsonProperty("is_tester")
    private boolean tester;
    private boolean moderator;
    @JsonProperty("hide_feedback")
    private boolean hideFeedback;
    @JsonProperty("can_post_big_forum_photos")
    private boolean postBigForumPhotosEnabled;
    @JsonProperty("allow_direct_messaging")
    private boolean directMessagingEnabled;
    //   @JsonProperty("bundle_discount")
    //   private Discount.Bundle bundleDiscount;
    @JsonProperty("donation_configuration")
    private Object donationConfiguration;
    private Object fundraiser;
    private boolean business;
    @JsonProperty("business_account")
    private Object businessAccount;
    @JsonProperty("has_confirmed_payments_account")
    private boolean confirmedPaymentsAccountVerified;
    @JsonProperty("has_ship_fast_badge")
    private boolean shipFastBadgeEnabled;
    @JsonProperty("total_items_count")
    private int totalItemsCount;
    private String about;
    //  private Verification verification;
    @JsonProperty("closet_promoted_until")
    private Date closetPromotedUntil;
    @JsonProperty("avg_response_time")
    private Object averageResponseTime;
    @JsonProperty("carrier_ids")
    private ArrayList<Integer> carrierIds;
    @JsonProperty("carriers_without_custom_ids")
    private ArrayList<Integer> carriersWithoutCustomIds;
    @JsonProperty("international_trading_enabled")
    private Object internationalTradingEnabled;
    private String locale;
    @JsonProperty("updated_on")
    private int updatedOn;
    @JsonProperty("is_hated")
    private boolean hated;
    @JsonProperty("hates_you")
    private boolean hatingYou;
    @JsonProperty("is_favourite")
    private boolean favourite;
    @JsonProperty("profile_url")
    private String profileUrl;
    @JsonProperty("share_profile_url")
    private String shareProfileUrl;
    @JsonProperty("facebook_user_id")
    private Object facebookUserId;
    @JsonProperty("is_online")
    private boolean online;
    @JsonProperty("has_promoted_closet")
    private boolean promotedClosetEnabled;
    @JsonProperty("can_view_profile")
    private boolean canViewProfile;
    @JsonProperty("can_bundle")
    private boolean bundleEnabled;
    @JsonProperty("has_item_alerts")
    private boolean hasItemAlerts;
    @JsonProperty("has_replica_proof_items")
    private boolean hasReplicaProofItems;
    @JsonProperty("external_id")
    private String externalId;
    @JsonProperty("required_location")
    private boolean locationRequired;
    @JsonProperty("generated_login")
    private boolean generatedLogin;
    @JsonProperty("infoboard_seen")
    private boolean infoboardSeen;
    @JsonProperty("soft_restricted_by_terms")
    private boolean softRestrictedByTerms;
    @JsonProperty("terms_update_available")
    private boolean termsUpdateAvailable;
    @JsonProperty("restricted_by_unconfirmed_real_name")
    private boolean restrictedByUnconfirmedRealName;
    @JsonProperty("restricted_by_balance_activation")
    private boolean restrictedByBalanceActivation;
    //  @JsonProperty("accepted_pay_in_methods")
    //  private ArrayList<PaymentMethod> acceptedPaymentsMethods;
    private String localization;

}
