package me.rochblondiaux.vinted4j.http.request;

import lombok.extern.log4j.Log4j2;
import me.rochblondiaux.vinted4j.VintedClient;
import me.rochblondiaux.vinted4j.VintedConstants;
import me.rochblondiaux.vinted4j.http.response.VintedResponse;
import okhttp3.HttpUrl;


@Log4j2
public abstract class VintedRequest<R extends VintedResponse> {

    public abstract String endpoint();

    public abstract Class<R> responseType();

    public String apiPath() {
        return VintedConstants.API_V2;
    }

    public String baseApiUrl() {
        return VintedConstants.BASE_API_URL;
    }

    public String getQueryString(VintedClient client) {
        return "";
    }

    public HttpUrl url(VintedClient client) {
        return HttpUrl.parse(baseApiUrl() + apiPath() + endpoint() + getQueryString(client));
    }
}
