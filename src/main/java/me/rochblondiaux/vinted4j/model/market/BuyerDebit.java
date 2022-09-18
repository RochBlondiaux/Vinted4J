package me.rochblondiaux.vinted4j.model.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import me.rochblondiaux.vinted4j.model.user.PaymentMethod;

@Data
public class BuyerDebit {

    private long id;
    @JsonProperty("credit_card_id")
    private Object creditCardId;
    @JsonProperty("external_card_code")
    private Object externalCardCode;
    private long offer_id;
    private int status;
    @JsonProperty("seller_share")
    private String sellerShare;
    @JsonProperty("marketplace_share")
    private String marketplaceShare;
    @JsonProperty("shipment_price")
    private String shipmentPrice;
    @JsonProperty("service_fee")
    private String serviceFee;
    @JsonProperty("item_discount")
    private String itemDiscount;
    @JsonProperty("item_discount_type")
    private int itemDiscountType;
    @JsonProperty("shipment_discount")
    private String shipmentDiscount;
    @JsonProperty("service_fee_discount")
    private String serviceFeeDiscount;
    @JsonProperty("totalAmount")
    private String total_amount;
    @JsonProperty("pay_in_amount")
    private String payInAmount;
    @JsonProperty("pay_in_redirect_url")
    private Object payInRedirectUrl;
    @JsonProperty("failure_reason")
    private Object failureReason;
    @JsonProperty("item_price")
    private String itemPrice;
    @JsonProperty("item_price_seller_share")
    private String itemPriceSellerShare;
    @JsonProperty("total_shipment_price")
    private String totalShipmentPrice;
    @JsonProperty("total_without_shipment")
    private String totalWithoutShipment;
    @JsonProperty("fx_rate_with_markup")
    private String fxRateWithMarkup;
    @JsonProperty("wallet_amount")
    private String walletAmount;
    private Object conversion;
    private String discount;
    @JsonProperty("card_amount")
    private String cardAmount;
    @JsonProperty("pay_in_method")
    private PaymentMethod paymentMethod;
    private String currency;
    @JsonProperty("authenticity_service_fee")
    private String authenticityServiceFee;
    @JsonProperty("service_fee_without_discount")
    private String serviceFeeWithoutDiscount;
}
