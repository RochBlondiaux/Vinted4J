package me.rochblondiaux.vinted4j.model.catalog.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SearchTrackingParams {

    private double score;
    @JsonProperty("matched_queries")
    private List<String> matchedQueries;
    @JsonProperty("search_correlation_id")
    private String correlationId;
    @JsonProperty("search_session_id")
    private String sessionId;
    @JsonProperty("global_search_session_id")
    private String globalSessionId;
}
