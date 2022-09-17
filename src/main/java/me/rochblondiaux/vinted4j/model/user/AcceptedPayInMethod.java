package me.rochblondiaux.vinted4j.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AcceptedPayInMethod {

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
