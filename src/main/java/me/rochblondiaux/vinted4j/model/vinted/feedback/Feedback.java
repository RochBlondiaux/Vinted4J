package me.rochblondiaux.vinted4j.model.vinted.feedback;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import me.rochblondiaux.vinted4j.model.vinted.user.User;

import java.util.Date;

@Data
public class Feedback {

    private int id;
    @JsonProperty("item_title")
    private String itemTitle;
    @JsonProperty("item_id")
    private Object itemId;
    @JsonProperty("feedback")
    private String content;
    private int rating;
    @JsonProperty("feedback_rate")
    private int feedbackRate;
    @JsonProperty("feedback_user_id")
    private int authorId;
    @JsonProperty("system_feedback")
    private boolean systemFeedback;
    @JsonProperty("is_system_comment")
    private Object systemComment;
    @JsonProperty("external_type")
    private Object externalType;
    private Comment comment;
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user")
    private User author;
    @JsonProperty("can_change")
    private boolean changeable;
    @JsonProperty("can_delete")
    private boolean deletable;
    @JsonProperty("can_comment")
    private boolean commentable;
    @JsonProperty("can_change_comment")
    private boolean commentChangeable;
    @JsonProperty("can_delete_comment")
    private boolean commentDeletable;
    private String localization;

    @JsonProperty("created_at")
    private String createdAtRaw;
    @JsonProperty("created_at_ts")
    private Date createdAt;
}
