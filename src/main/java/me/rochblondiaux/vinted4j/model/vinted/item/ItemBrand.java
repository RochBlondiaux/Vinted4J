package me.rochblondiaux.vinted4j.model.vinted.item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Getter
@RequiredArgsConstructor
public enum ItemBrand {
    KIABI(60),
    ZARA(12),
    H_M(7),
    SHEIN(172724),
    ORCHESTRA(13347),
    NIKE(53),
    JENNYPHER(43),
    GEMO(144),
    ADIDAS(14),
    TAPE_A_L_OEIL(16377),
    PIMKIE(3),
    DISNEY(34),
    OKAIDI(571),
    CAMAIEU(26),
    VINTAGE(573),
    UNKNOW(465),
    PRIMARK(105),
    BERSHKA(140),
    VERTBAUDET(17143),
    CACHE_CACHE(57),
    SERGENANT_MAJOR(3921),
    MANGO(15),
    IN_EXTENSO(405),
    DECATHLON(386),
    LEVIS(10),
    PROMOD(5),
    PETIT_BATEAU(149),
    PULL_AND_BEAR(4690593),
    OBAIBI(174100),
    POKEMON(191646),
    DU_PAREIL_AU_MEME(90),
    PUMA(535),
    IKKS(61),
    ETAM(101),
    TEX(92),
    TISSAIA(2571),
    STRADIVARIUS(41),
    NAF_NAF(177),
    PLAYMOBIL(287243),
    C_AND_A(11425),
    LA_HALLE(211),
    FAIT_MAIN(2),
    LACOSTE(304),
    TAO(175716),
    TOMMY_HILFIGER(94),
    KAPORAL(273),
    BONOBO(47),
    CELIO(2615),
    RALPH_LAUREN(88),
    CATIMINI(7835),
    ALEXANDER_MCQUEEN(52193),
    GUCCI(567),
    LOUIS_VUITTON(417),
    DIOR(671),
    YVES_SAINT_LAURENT(377),
    STONE_ISLAND(73306),
    YEEZY(115490),

    ;
    private final int id;
}
