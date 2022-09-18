package me.rochblondiaux.vinted4j.model.http.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import me.rochblondiaux.vinted4j.model.http.VintedBaseModel;

@Data
public class VintedResponse extends VintedBaseModel {

    private String status;
    @JsonIgnore
    private int statusCode;
    private String error;
    @JsonProperty("error_description")
    private String errorDescription;
    private String message;
    private int code;
}