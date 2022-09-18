package me.rochblondiaux.vinted4j.model.inbox;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import me.rochblondiaux.vinted4j.model.user.User;

import java.util.Date;
import java.util.List;

@Data
public class Conversation {

    private long id;
    @JsonProperty("item_count")
    private int items;
    private String description;
    private boolean unread;
    @JsonProperty("updated_at")
    private Date updatedAt;
    @JsonProperty("opposite_user")
    private User recipient;
    @JsonProperty("item_photos")
    private List<Object> itemPhotos;
    @JsonProperty("read_by_current_user")
    private boolean readByCurrentUser;
    @JsonProperty("read_by_opposite_user")
    private boolean readByOppositeRecipient;
    private String localization;
    private boolean translated;
    @JsonProperty("allow_reply")
    private boolean replyAllowed;
    @JsonProperty("is_suspicious")
    private boolean suspicious;
    private String subtitle;
    private List<Message> messages;
    @JsonProperty("suggested_messages")
    private List<Object> suggestedMessages;
    private Object transaction;
    private Object education;
    private Object moderated_items;
}
