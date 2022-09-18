package me.rochblondiaux.vinted4j.model.vinted.item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Getter
@RequiredArgsConstructor
public enum ItemColor {
    BLACK(1),
    GRAY(3),
    WHITE(12),
    CREAM(20),
    BEIGE(4),
    APRICOT(21),
    ORANGE(11),
    CORAL(22),
    RED(7),
    BURGUNDY(23),
    PINK(5),
    ROSE(24),
    PURPLE(6),
    LILAC(25),
    LIGHT_BLUE(26),
    BLUE(9),
    NAVY(27),
    TURQUOISE(17),
    MINT(30),
    GREEN(10),
    DARK_GREEN(28),
    KHAKI(16),
    BROWN(2),
    MUSTARD(29),
    YELLOW(8),
    SILVER(13),
    GOLD(14),
    MULTICOLORED(15),
    ;

    private final int id;
}
