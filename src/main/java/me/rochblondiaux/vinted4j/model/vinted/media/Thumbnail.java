package me.rochblondiaux.vinted4j.model.vinted.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Thumbnail {

    private String type;
    private String url;
    private int width;
    private int height;
    @JsonProperty("original_size")
    private Object originalSize;
}
