package me.rochblondiaux.vinted4j.exceptions;

public interface ExceptionallyHandler {


    <T> T handle(Throwable throwable, Class<T> type);
}