package me.rochblondiaux.vinted4j.http.response.catalog;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import me.rochblondiaux.vinted4j.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.model.catalog.Brand;
import me.rochblondiaux.vinted4j.model.catalog.item.Item;
import me.rochblondiaux.vinted4j.model.catalog.search.Pagination;
import me.rochblondiaux.vinted4j.model.catalog.search.SearchTrackingParams;

import java.util.List;

@Data
public class SearchResponse extends VintedResponse {

    private List<Item> items;
    @JsonProperty("dominant_brand")
    private Brand dominantBrand;
    @JsonProperty("search_tracking_params")
    private SearchTrackingParams searchTrackingParams;
    private Pagination pagination;
}
