package me.rochblondiaux.vinted4j.model.catalog;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Brand {

    private int id;
    private String title;
    private String slug;
    @JsonProperty("favourite_count")
    private int favourites;
    @JsonProperty("pretty_favourite_count")
    private String prettyFavourites;
    @JsonProperty("item_count")
    private int items;
    @JsonProperty("pretty_item_count")
    private String prettyItems;
    @JsonProperty("is_visible_in_listings")
    private boolean visibleInListings;
    private String path;
    @JsonProperty("requires_authenticity_check")
    private boolean authenticityCheckRequired;
    @JsonProperty("is_luxury")
    private boolean luxury;
    private String url;
    @JsonProperty("is_favourite")
    private boolean favourite;
}
