package me.rochblondiaux.vinted4j.model.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PackageSize {

    private int id;
    private String code;
    private String title;
    @JsonProperty("weight_description")
    private String weightDescription;
    @JsonProperty("format_description")
    private String formatDescription;
    private boolean custom;
    private boolean standard;
    @JsonProperty("education_text")
    private String educationText;
}
