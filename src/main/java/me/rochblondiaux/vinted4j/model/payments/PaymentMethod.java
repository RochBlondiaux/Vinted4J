package me.rochblondiaux.vinted4j.model.payments;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentMethod {

    private int id;
    private String code;
    @JsonProperty("requires_credit_card")
    private boolean creditCardRequired;
    @JsonProperty("event_tracking_code")
    private String eventTrackingCode;
    private String icon;
    private boolean enabled;
    @JsonProperty("translated_name")
    private String translatedName;
    private String note;
}
