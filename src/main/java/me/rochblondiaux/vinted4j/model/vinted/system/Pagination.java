package me.rochblondiaux.vinted4j.model.vinted.system;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Pagination {

    @JsonProperty("current_page")
    private int currentPage;
    @JsonProperty("total_pages")
    private int totalPages;
    @JsonProperty("total_entries")
    private int totalEntries;
    @JsonProperty("per_page")
    private int perPage;
    private int time;
}
