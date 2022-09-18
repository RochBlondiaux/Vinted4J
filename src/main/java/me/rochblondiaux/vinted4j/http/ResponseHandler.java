package me.rochblondiaux.vinted4j.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import kotlin.Pair;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import me.rochblondiaux.vinted4j.VintedClient;
import me.rochblondiaux.vinted4j.exceptions.VintedResponseException;
import me.rochblondiaux.vinted4j.http.request.VintedRequest;
import me.rochblondiaux.vinted4j.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.utils.VintedUtils;
import okhttp3.Response;

import java.io.IOException;

@Log4j2
public record ResponseHandler<T extends VintedResponse, R extends VintedRequest<T>>(R request, VintedClient client) {

    @SneakyThrows(IOException.class)
    public T parseResponse(Pair<Response, String> response) {
        T res = parseResponse(response.getSecond());
        res.setStatusCode(response.getFirst().code());
        if (!response.getFirst().isSuccessful() || (res.getStatus() != null && res.getStatus().equals("fail")))
            throw new VintedResponseException(res);
        return res;
    }

    public T parseResponse(String json) throws JsonProcessingException {
        return parseResponse(json, request.responseType());
    }

    public <U> U parseResponse(String json, Class<U> type) throws JsonProcessingException {
        log.debug("{}{} parsing response : {}", request.apiPath(), request.endpoint(client), json);
        return VintedUtils.jsonToObject(json, type);
    }
}
