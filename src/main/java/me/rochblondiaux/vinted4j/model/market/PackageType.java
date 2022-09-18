package me.rochblondiaux.vinted4j.model.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class PackageType {

    private int id;
    private String code;
    private String title;
    private String weight_from;
    @JsonProperty("weight_to")
    private String weightTo;
    @JsonProperty("weight_units")
    private String weightUnits;
    private String price;
    private String currency;
    @JsonProperty("first_mile_carrier_id")
    private int firstMileCarrierId;
    @JsonProperty("last_mile_carrier_id")
    private int lastMileCarrierId;
    @JsonProperty("direct_injection")
    private boolean directInjection;
    @JsonProperty("primary_carrier_id")
    private Object primaryCarrierId;
    @JsonProperty("carrier_service")
    private String carrierService;
    @JsonProperty("carrier_service_label")
    private String carrierServiceLabel;
    @JsonProperty("is_fixed_price")
    private boolean fixedPrice;
    @JsonProperty("label_type")
    private int labelType;
    private String subtitle;
    @JsonProperty("buyer_phone_requirement")
    private String buyerPhoneRequirement;
    @JsonProperty("seller_phone_requirement")
    private String sellerPhoneRequirement;
    @JsonProperty("delivery_type")
    private int deliveryType;
    @JsonProperty("shipment_instructions")
    private String shipmentInstructions;
    @JsonProperty("online_purchase")
    private boolean onlinePurchase;
    private boolean untracked;
    @JsonProperty("pickup_only")
    private boolean pickupOnly;
    @JsonProperty("seller_price")
    private String sellerPrice;
    @JsonProperty("drop_off_type_ids")
    private ArrayList<Long> dropOffTypeIds;
    @JsonProperty("no_shipping")
    private boolean noShipping;
    @JsonProperty("shipment_type")
    private String shipmentType;
    @JsonProperty("shipment_delivery_type")
    private int shipmentDeliveryType;
    @JsonProperty("package_size_code")
    private String packageSizeCode;
    @JsonProperty("price_label")
    private String priceLabel;
    @JsonProperty("value_proposition")
    private String valueProposition;
    @JsonProperty("drop_off_types")
    private ArrayList<Object> dropOffTypes;
}
