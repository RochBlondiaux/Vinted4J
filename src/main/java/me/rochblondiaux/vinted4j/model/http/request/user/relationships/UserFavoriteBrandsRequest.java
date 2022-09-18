package me.rochblondiaux.vinted4j.model.http.request.user.relationships;


import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.model.http.request.method.GETRequest;
import me.rochblondiaux.vinted4j.model.http.response.brand.BrandListResponse;

public record UserFavoriteBrandsRequest(long userId, int page, int perPage) implements GETRequest<BrandListResponse> {

    @Override
    public String endpoint(VintedAPI client) {
        return "users/%d/brands?per_page=%d&page=%d".formatted(userId, perPage, page);
    }

    @Override
    public Class<BrandListResponse> responseType() {
        return BrandListResponse.class;
    }
}
