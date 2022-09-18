package me.rochblondiaux.vinted4j.http.request.catalog;

import lombok.RequiredArgsConstructor;
import me.rochblondiaux.vinted4j.VintedClient;
import me.rochblondiaux.vinted4j.http.request.GetRequest;
import me.rochblondiaux.vinted4j.http.response.catalog.SearchResponse;
import me.rochblondiaux.vinted4j.model.catalog.Search;

@RequiredArgsConstructor
public class SearchRequest extends GetRequest<SearchResponse> {

    private final Search search;

    @Override
    public String endpoint(VintedClient client) {
        return "catalog/items?%s".formatted(search.toQuery());
    }

    @Override
    public Class<SearchResponse> responseType() {
        return SearchResponse.class;
    }

}
