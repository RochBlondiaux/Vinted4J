package me.rochblondiaux.vinted4j.model.http.request.authentification;

import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.model.http.VintedBaseModel;
import me.rochblondiaux.vinted4j.model.http.request.method.POSTRequest;
import me.rochblondiaux.vinted4j.model.http.request.PayloadRequest;
import me.rochblondiaux.vinted4j.model.http.response.VintedResponse;

public class LogoutRequest extends PayloadRequest<VintedResponse> implements POSTRequest<VintedResponse> {

    @Override
    public VintedBaseModel payload(VintedAPI api) {
        return new VintedBaseModel();
    }

    @Override
    public boolean isJSON() {
        return false;
    }

    @Override
    public String endpoint(VintedAPI client) {
        return "member/general/logout";
    }

    @Override
    public String apiPath() {
        return "";
    }

    @Override
    public Class<VintedResponse> responseType() {
        return VintedResponse.class;
    }
}
