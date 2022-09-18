package me.rochblondiaux.vinted4j.factory;

import me.rochblondiaux.vinted4j.VintedClient;
import me.rochblondiaux.vinted4j.http.request.DeleteRequest;
import me.rochblondiaux.vinted4j.http.response.VintedResponse;
import okhttp3.Request;

public class DeleteRequestFactory<R extends VintedResponse, T extends DeleteRequest<R>> implements RequestFactory<R, T> {

    @Override
    public Request create(VintedClient client, T request) {
        Request.Builder builder = new Request.Builder()
                .url(request.url(client))
                .delete();

        return addDefaultHeader(client, builder).build();
    }
}
