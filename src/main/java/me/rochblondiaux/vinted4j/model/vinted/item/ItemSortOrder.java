package me.rochblondiaux.vinted4j.model.vinted.item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ItemSortOrder {
    RELEVANCE,
    PRICE_HIGH_TO_LOW,
    PRICE_LOW_TO_HIGH,
    NEWEST_FIRST,
    ;

}
