package me.rochblondiaux.vinted4j.actions.user;

import lombok.RequiredArgsConstructor;
import me.rochblondiaux.vinted4j.VintedAPI;
import me.rochblondiaux.vinted4j.model.http.request.feedback.FeedBackListRequest;
import me.rochblondiaux.vinted4j.model.http.request.user.UserItemListRequest;
import me.rochblondiaux.vinted4j.model.http.request.user.relationships.UserFavoriteBrandsRequest;
import me.rochblondiaux.vinted4j.model.http.request.user.relationships.UserFollowersRequest;
import me.rochblondiaux.vinted4j.model.http.request.user.relationships.UserFollowingsRequest;
import me.rochblondiaux.vinted4j.model.vinted.feedback.Feedback;
import me.rochblondiaux.vinted4j.model.vinted.item.Brand;
import me.rochblondiaux.vinted4j.model.vinted.item.Item;
import me.rochblondiaux.vinted4j.model.vinted.item.ItemSortOrder;
import me.rochblondiaux.vinted4j.model.vinted.user.User;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
public class UserAction {

    private final VintedAPI api;
    private final User user;

    /* Brands */
    public CompletableFuture<List<Brand>> favoritesBrands(int page, int perPage) {
        return api.getRequestService()
                .send(new UserFavoriteBrandsRequest(user.getId(), page, perPage))
                .thenApply(brandListResponse -> {
                    if (brandListResponse.getBrands() == null)
                        throw new RuntimeException("Failed to get brands for user %s".formatted(user.getId()));
                    return brandListResponse.getBrands();
                });
    }

    public CompletableFuture<List<Brand>> favoritesBrands(int page) {
        return favoritesBrands(page, 10);
    }

    public CompletableFuture<List<Brand>> favoritesBrands() {
        return favoritesBrands(1, 10);
    }


    /* Followings */
    public CompletableFuture<List<User>> followings(int page, int perPage) {
        return api.getRequestService()
                .send(new UserFollowingsRequest(user.getId(), page, perPage))
                .thenApply(usersListResponse -> {
                    if (usersListResponse.getUsers() == null)
                        throw new RuntimeException("Failed to get followings for user %s".formatted(user.getId()));
                    return usersListResponse.getUsers();
                });
    }

    public CompletableFuture<List<User>> followings(int page) {
        return followings(page, 10);
    }

    public CompletableFuture<List<User>> followings() {
        return followings(1, 10);
    }

    /* Followers */
    public CompletableFuture<List<User>> getFollowers(int page, int perPage) {
        return api.getRequestService()
                .send(new UserFollowersRequest(user.getId(), page, perPage))
                .thenApply(usersListResponse -> {
                    if (usersListResponse.getUsers() == null)
                        throw new RuntimeException("Failed to get followers for user %s".formatted(user.getId()));
                    return usersListResponse.getUsers();
                });
    }

    public CompletableFuture<List<User>> getFollowers(int page) {
        return getFollowers(page, 20);
    }

    public CompletableFuture<List<User>> getFollowers() {
        return getFollowers(1);
    }


    /* Items */
    public CompletableFuture<List<Item>> items(ItemSortOrder order, int page, int perPage) {
        return api.getRequestService()
                .send(new UserItemListRequest(user.getId(), order.name().toLowerCase(), page, perPage))
                .thenApply(userItemListResponse -> {
                    if (userItemListResponse.getItems() == null)
                        throw new RuntimeException("Failed to get items for user %s".formatted(user.getId()));
                    return userItemListResponse.getItems();
                });
    }

    public CompletableFuture<List<Item>> items(int page, int perPage) {
        return items(ItemSortOrder.RELEVANCE, page, perPage);
    }

    public CompletableFuture<List<Item>> items(int page) {
        return items(ItemSortOrder.RELEVANCE, page, 20);
    }

    public CompletableFuture<List<Item>> items(ItemSortOrder order, int page) {
        return items(order, page, 20);
    }

    public CompletableFuture<List<Item>> items() {
        return items(ItemSortOrder.RELEVANCE, 1, 20);
    }


    /* Feedbacks */
    public CompletableFuture<List<Feedback>> feedbacks(int page, int perPage) {
        return api.getRequestService()
                .send(new FeedBackListRequest(user.getId(), page, perPage))
                .thenApply(feedBackListResponse -> {
                    final List<Feedback> feedbacks = feedBackListResponse.getFeedbacks();
                    if (feedbacks == null)
                        throw new RuntimeException("Failed to get feedbacks for user %s".formatted(user.getId()));
                    return feedbacks;
                });
    }

    public CompletableFuture<List<Feedback>> feedbacks(int page) {
        return this.feedbacks(page, 10);
    }

    public CompletableFuture<List<Feedback>> feedbacks() {
        return this.feedbacks(1, 10);
    }


}
