package me.rochblondiaux.vinted4j.model.payments;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class Discount {

    @JsonProperty("minimal_item_count")
    private int minimalItem;
    private String fraction;

    @Data
    @NoArgsConstructor
    public static class Bundle {

        private int id;
        @JsonProperty("user_id")
        private int userId;
        private boolean enabled;
        @JsonProperty("minimal_item_count")
        private int minimalItem;
        private String fraction;
        private List<Discount> discounts = new ArrayList<>();
    }

}
