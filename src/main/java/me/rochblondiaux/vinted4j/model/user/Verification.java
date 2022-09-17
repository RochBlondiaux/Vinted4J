package me.rochblondiaux.vinted4j.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Verification {

    private Email email;
    private Facebook facebook;
    private Google google;
    private Phone phone;

    @Data
    public static class Google {
        private boolean valid;
        @JsonProperty("verified_at")
        private Date verifiedAt;
        private boolean available;
    }

    @Data
    public static class Facebook {
        private boolean valid;
        @JsonProperty("verified_at")
        private Date verifiedAt;
        private boolean available;
    }

    @Data
    public static class Email {
        private boolean valid;
        private boolean available;
    }

    @Data
    public static class Phone {
        private boolean valid;
        @JsonProperty("verified_at")
        private Date verifiedAt;
        private boolean available;
    }


}

