package me.rochblondiaux.vinted4j;

import lombok.Setter;
import lombok.experimental.UtilityClass;

@UtilityClass

public class VintedConstants {


    /**
     * Base API URL
     */
    public static final String BASE_API_URL = "https://www.vinted.com/";

    /**
     * API v1 URL
     */
    public static final String API_V2 = "api/v2/";

    /**
     * Vinted App Version
     */
    public static final String APP_VERSION = "21.28.1";

    /**
     * User Locale
     */
    @Setter
    public static String LOCALE = "fr_FR";

}
