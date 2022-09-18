package me.rochblondiaux.vinted4j.model.http.request;

import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.VintedConstants;
import me.rochblondiaux.vinted4j.model.http.response.VintedResponse;
import okhttp3.HttpUrl;

import java.util.concurrent.CompletableFuture;

public interface VintedRequest<R extends VintedResponse> {

    /**
     * Get the endpoint of the request.
     *
     * @return The endpoint of the request.
     */
    String endpoint(VintedAPI client);

    /**
     * Get the HTTP method of the request.
     *
     * @return The HTTP method of the request.
     */
    String method();

    /**
     * Get the response class of the request.
     *
     * @return The response class of the request.
     */
    Class<R> responseType();

    /**
     * Get the api path of the request.
     *
     * @return The api path of the request.
     */
    default String apiPath() {
        return VintedConstants.API_V2;
    }

    /**
     * Get the base url of the request.
     *
     * @return The base url of the request.
     */
    default String baseApiUrl() {
        return VintedConstants.BASE_API_URL;
    }

    /**
     * Get the query url of the request.
     *
     * @param api The api instance.
     * @return The query url of the request.
     */
    default String queryString(VintedAPI api) {
        return "";
    }

    /**
     * Get the full url of the request.
     *
     * @param api The api instance.
     * @return The full url of the request.
     */
    default HttpUrl url(VintedAPI api) {
        return HttpUrl.parse(baseApiUrl() + apiPath() + endpoint(api) + queryString(api));
    }

    /**
     * Execute the request.
     *
     * @param api The api instance.
     * @return The response of the request.
     */
    default CompletableFuture<R> send(VintedAPI api) {
        return api.getRequestService().send(this);
    }
}
