package me.rochblondiaux.vinted4j.model.market.carrier;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PackageCarrier {

    private int id;
    private String code;
    private String name;
    @JsonProperty("buyer_title")
    private String buyerTitle;
    @JsonProperty("buyer_hint")
    private String buyerHint;
    @JsonProperty("shipment_instructions")
    private String shipmentInstructions;
    @JsonProperty("reference_placeholder")
    private String referencePlaceholder;
    private boolean mandatory;
    @JsonProperty("preferred_choice")
    private boolean preferredChoice;
    @JsonProperty("promote_as_new")
    private boolean promoteAsNew;
    private boolean custom;
    @JsonProperty("icon_url")
    private String iconUrl;
    private String description;
    private Object restriction;
    @JsonProperty("delivery_type")
    private int deliveryType;
    @JsonProperty("shipment_delivery_type")
    private int shipmentDeliveryType;
    @JsonProperty("no_shipping")
    private boolean noShipping;
    @JsonProperty("pickup_only")
    private boolean pickupOnly;
}
