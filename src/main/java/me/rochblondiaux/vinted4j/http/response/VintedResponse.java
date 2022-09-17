package me.rochblondiaux.vinted4j.http.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import me.rochblondiaux.vinted4j.model.VintedBaseModel;

@Data
public class VintedResponse extends VintedBaseModel {

    private String status;
    @JsonIgnore
    private int statusCode;
    private String message;
    private boolean spam;
    private boolean lock;
    private String feedback_title;
    private String feedback_message;
    private String error_type;
    private String checkpoint_url;

}