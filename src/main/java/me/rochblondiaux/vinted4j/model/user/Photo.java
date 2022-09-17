package me.rochblondiaux.vinted4j.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Photo {

    private long id;
    private int width;
    private int height;
    @JsonProperty("temp_uuid")
    private Object tempUuid;
    private String url;
    @JsonProperty("dominant_color")
    private String dominantColor;
    @JsonProperty("dominant_color_opaque")
    private String dominantColorOpaque;
    private ArrayList<Thumbnail> thumbnails;
    @JsonProperty("is_suspicious")
    private boolean suspicious;
    private Object orientation;
    private Object reaction;
    @JsonProperty("high_resolution")
    private HighResolution highResolution;
    @JsonProperty("full_size_url")
    private String fullSizeUrl;
    @JsonProperty("isHidden")
    private boolean hidden;
    @JsonProperty("image_no")
    private int imageNo;

    @Data
    public static class HighResolution {
        private String id;
        private int timestamp;
        private Object orientation;
    }
}
