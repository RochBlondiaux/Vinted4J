package me.rochblondiaux.vinted4j.model.http.request.user;

import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.model.http.request.method.GETRequest;
import me.rochblondiaux.vinted4j.model.http.response.item.ItemListResponse;

public record UserItemListRequest(long userId, String order, int page,
                                  int perPage) implements GETRequest<ItemListResponse> {

    @Override
    public String endpoint(VintedAPI client) {
        return "users/%d/items?order=%s&page=%d&per_page=%d".formatted(userId, order, page, perPage);
    }

    @Override
    public Class<ItemListResponse> responseType() {
        return ItemListResponse.class;
    }
}
