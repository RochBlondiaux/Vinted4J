package me.rochblondiaux.vinted4j.factory.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import kotlin.Pair;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.exceptions.VintedResponseException;
import me.rochblondiaux.vinted4j.model.http.request.VintedRequest;
import me.rochblondiaux.vinted4j.model.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.utils.VintedUtils;
import okhttp3.Response;

import java.io.IOException;

@Log4j2
public record ResponseFactory<T extends VintedResponse, R extends VintedRequest<T>>(R request, VintedAPI api) {

    @SneakyThrows(IOException.class)
    public T make(Pair<Response, String> response) {
        T res = make(response.getSecond());
        res.setStatusCode(response.getFirst().code());
        if (!response.getFirst().isSuccessful() || (res.getStatus() != null && res.getStatus().equals("fail")))
            throw new VintedResponseException(res);
        return res;
    }

    public T make(String json) throws JsonProcessingException {
        return make(json, request.responseType());
    }

    public <U> U make(String json, Class<U> type) throws JsonProcessingException {
        log.debug("{}{} parsing response : {}", request.apiPath(), request.endpoint(api), json);
        return VintedUtils.jsonToObject(json, type);
    }
}
