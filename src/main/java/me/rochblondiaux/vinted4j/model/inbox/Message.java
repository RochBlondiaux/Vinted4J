package me.rochblondiaux.vinted4j.model.inbox;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Message {

    @JsonProperty("entity_type")
    private String entityType;
    private MessageEntity entity;
    @JsonProperty("created_at_ts")
    private Date createdAt;
    @JsonProperty("created_time_ago")
    private String creationTimeAgo;
}
