package me.rochblondiaux.vinted4j.model.vinted.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Address {

    private int id;
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("country_id")
    private int countryId;
    @JsonProperty("entry_type")
    private int entryType;
    private String name;
    @JsonProperty("postal_code")
    private String postalCode;
    private String city;
    private String state;
    private String line1;
    private String line2;
    @JsonProperty("phone_number")
    private String phoneNumber;
}
