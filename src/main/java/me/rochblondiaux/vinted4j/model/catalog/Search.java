package me.rochblondiaux.vinted4j.model.catalog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import me.rochblondiaux.vinted4j.model.catalog.item.ItemBrand;
import me.rochblondiaux.vinted4j.model.catalog.item.ItemColor;
import me.rochblondiaux.vinted4j.model.catalog.item.ItemState;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Accessors(fluent = true)
@Getter
@AllArgsConstructor
public class Search {

    private String query;
    private int categoryId;
    private double minimumPrice;
    private double maximumPrice;
    private boolean forSwap;
    private int page;
    private int itemPerPage;
    private final List<Integer> brandIds;
    private final List<Integer> sizeIds;
    private final List<Integer> materialIds;
    private final List<Integer> videoGameRatingIds;
    private final List<Integer> stateIds;
    private final List<Integer> colorIds;

    public String toQuery() {
        List<String> params = new ArrayList<>();
        if (query != null && !query.isEmpty())
            params.add("search_text=%s".formatted(query));
        if (categoryId != 0)
            params.add("catalog_ids=%d".formatted(categoryId));
        if (minimumPrice != 0)
            params.add("price_from=%f".formatted(minimumPrice));
        if (maximumPrice != 0)
            params.add("price_to=%f".formatted(maximumPrice));
        params.add("is_for_swap=%d".formatted(forSwap ? 1 : 0));
        params.add("page=%d".formatted(page));
        params.add("per_page=%d".formatted(itemPerPage));
        params.add("brand_ids=%s".formatted(brandIds.stream().map(String::valueOf).collect(Collectors.joining(","))));
        params.add("size_ids=%s".formatted(sizeIds.stream().map(String::valueOf).collect(Collectors.joining(","))));
        params.add("material_ids=%s".formatted(materialIds.stream().map(String::valueOf).collect(Collectors.joining(","))));
        params.add("video_game_rating_ids=%s".formatted(videoGameRatingIds.stream().map(String::valueOf).collect(Collectors.joining(","))));
        params.add("status_ids=%s".formatted(stateIds.stream().map(String::valueOf).collect(Collectors.joining(","))));
        params.add("color_ids=%s".formatted(colorIds.stream().map(String::valueOf).collect(Collectors.joining(","))));
        return String.join("&", params);
    }

    public void nextPage() {
        page++;
    }

    public void previousPage() {
        if (page > 1)
            page--;
    }

    @Accessors(fluent = true)
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Builder {

        private String query;
        private int categoryId;
        private double minimumPrice;
        private double maximumPrice;
        private boolean forSwap = false;
        private int page = 1;
        private int itemPerPage = 24;
        private final List<ItemBrand> brands = new ArrayList<>();
        private final List<Integer> sizes = new ArrayList<>();
        private final List<Integer> materials = new ArrayList<>();
        private final List<Integer> videoGameRatings = new ArrayList<>();
        private final List<ItemState> states = new ArrayList<>();
        private final List<ItemColor> colors = new ArrayList<>();

        public Builder brand(ItemBrand brand) {
            this.brands.add(brand);
            return this;
        }

        public Builder brands(ItemBrand... brands) {
            this.brands.addAll(List.of(brands));
            return this;
        }

        public Builder size(int sizeId) {
            this.sizes.add(sizeId);
            return this;
        }

        public Builder material(int materialId) {
            this.materials.add(materialId);
            return this;
        }

        public Builder videoGameRating(int videoGameRatingId) {
            this.videoGameRatings.add(videoGameRatingId);
            return this;
        }

        public Builder state(ItemState state) {
            this.states.add(state);
            return this;
        }

        public Builder states(ItemState... states) {
            this.states.addAll(List.of(states));
            return this;
        }

        public Builder color(ItemColor color) {
            this.colors.add(color);
            return this;
        }

        public Builder colors(ItemColor... colors) {
            this.colors.addAll(List.of(colors));
            return this;
        }

        public Search build() {
            return new Search(
                    query,
                    categoryId,
                    minimumPrice,
                    maximumPrice,
                    forSwap,
                    page,
                    itemPerPage,
                    brands.stream()
                            .map(ItemBrand::id)
                            .collect(Collectors.toList()),
                    sizes,
                    materials,
                    videoGameRatings,
                    states.stream()
                            .map(ItemState::id)
                            .collect(Collectors.toList()),
                    colors.stream()
                            .map(ItemColor::id)
                            .collect(Collectors.toList())
            );
        }
    }
}
