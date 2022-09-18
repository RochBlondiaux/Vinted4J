package me.rochblondiaux.vinted4j.model.vinted.feedback;

import lombok.Data;
import me.rochblondiaux.vinted4j.model.vinted.user.User;

@Data
public class Comment {

    private User user;
    private Object comment;
}
