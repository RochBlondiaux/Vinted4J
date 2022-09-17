package me.rochblondiaux.vinted4j.exceptions;

public interface ExceptionallyHandler {

    static ExceptionallyHandler WRAPPED_TO_RESPONSE = new ExceptionallyHandler() {

        @Override
        public <T> T handle(Throwable throwable, Class<T> type) {
            return VintedResponseException.VintedFailedResponse.of(throwable.getCause(), type);
        }

    };


    <T> T handle(Throwable throwable, Class<T> type);
}