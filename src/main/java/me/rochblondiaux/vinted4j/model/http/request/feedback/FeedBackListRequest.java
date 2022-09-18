package me.rochblondiaux.vinted4j.model.http.request.feedback;

import lombok.RequiredArgsConstructor;
import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.model.http.request.method.GETRequest;
import me.rochblondiaux.vinted4j.model.http.response.feedback.FeedBackListResponse;

@RequiredArgsConstructor
public class FeedBackListRequest implements GETRequest<FeedBackListResponse> {

    private final long userId;
    private final int page;
    private final int perPage;


    @Override
    public String endpoint(VintedAPI client) {
        return "feedbacks?page=%d&per_page=%d&user_id=%d&time=0".formatted(page, perPage, userId);
    }

    @Override
    public Class<FeedBackListResponse> responseType() {
        return FeedBackListResponse.class;
    }
}
