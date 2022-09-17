package me.rochblondiaux.vinted4j.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import me.rochblondiaux.vinted4j.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.utils.VintedUtils;

import java.io.IOException;

@Getter
public class VintedResponseException extends IOException {

    @NonNull
    private final VintedResponse response;

    public VintedResponseException(VintedResponse response) {
        super(response.getMessage());
        this.response = response;
    }

    @Data
    public static class VintedFailedResponse extends VintedResponse {
        private String status = "fail";
        private final String message;

        public static VintedResponse of(Throwable throwable) {
            if (throwable instanceof VintedResponseException rException)
                return rException.getResponse();
            return new VintedFailedResponse(throwable.toString());
        }

        public static <T> T of(Throwable throwable, Class<T> clazz) {
            return VintedUtils.convertToView(of(throwable), clazz);
        }
    }

}