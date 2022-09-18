package me.rochblondiaux.vinted4j.model.vinted.item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Getter
@RequiredArgsConstructor
public enum ItemState {
    NEW_WITH_TAG(6),
    NEW_WITHOUT_TAG(1),
    REALLY_GOOD(2),
    GOOD(3),
    SATISFACTORY(4);

    private final int id;
}
