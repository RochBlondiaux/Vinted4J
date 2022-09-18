package me.rochblondiaux.vinted4j.model.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import me.rochblondiaux.vinted4j.model.market.carrier.PackageCarrier;
import me.rochblondiaux.vinted4j.model.user.Address;

import java.util.Date;

@Data
public class Shipment {

    private long id;
    @JsonProperty("entry_type")
    private int entryType;
    @JsonProperty("transaction_id")
    private long transactionId;
    @JsonProperty("drop_off_type_id")
    private long dropOffTypeId;
    private String price;
    private String currency;
    private int status;
    private Object tracking_code;
    @JsonProperty("status_label")
    private String statusLabel;
    @JsonProperty("status_updated_at")
    private Date statusUpdatedAt;
    @JsonProperty("label_type")
    private Object labelType;
    @JsonProperty("from_address")
    private Address fromAddress;
    @JsonProperty("to_address")
    private Address toAddress;
    @JsonProperty("pickup_point")
    private Object pickupPoint;
    @JsonProperty("selected_pickup_point_code")
    private Object selectedPickupPointCode;
    @JsonProperty("pickup_points")
    private Object pickupPoints;
    @JsonProperty("package_type")
    private PackageType packageType;
    private PackageCarrier carrier;
    @JsonProperty("carrier_id")
    private int carrierId;
    @JsonProperty("first_mile_carrier")
    private PackageCarrier firstMileCarrier;
    @JsonProperty("last_mile_carrier")
    private PackageCarrier lastMileCarrier;
    @JsonProperty("label_url")
    private String labelUrl;
    @JsonProperty("price_label")
    private String priceLabel;
    @JsonProperty("status_title")
    private String statusTitle;
    @JsonProperty("digital_label_types")
    private Object digitalLabelTypes;
    @JsonProperty("rate_uuid")
    private Object rateUuid;
}
