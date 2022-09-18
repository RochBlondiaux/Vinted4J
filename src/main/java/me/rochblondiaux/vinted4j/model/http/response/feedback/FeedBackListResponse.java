package me.rochblondiaux.vinted4j.model.http.response.feedback;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import me.rochblondiaux.vinted4j.model.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.model.vinted.feedback.Feedback;
import me.rochblondiaux.vinted4j.model.vinted.system.Pagination;

import java.util.ArrayList;
import java.util.List;

@Data
public class FeedBackListResponse extends VintedResponse {

    @JsonProperty("user_feedbacks")
    private List<Feedback> feedbacks = new ArrayList<>();
    private Pagination pagination;
}
