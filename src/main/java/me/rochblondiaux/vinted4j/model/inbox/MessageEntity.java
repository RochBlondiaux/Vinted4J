package me.rochblondiaux.vinted4j.model.inbox;

import com.fasterxml.jackson.annotation.JsonProperty;
import me.rochblondiaux.vinted4j.model.user.Photo;

import java.util.List;

public class MessageEntity {

    private String body;
    private List<Photo> photos;
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("sent_via_mobile")
    private boolean sentViaMobile;
    private long id;
    private Object reaction;
    @JsonProperty("is_hidden")
    private boolean hidden;
}
