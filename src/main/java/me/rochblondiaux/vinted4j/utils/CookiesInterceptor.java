package me.rochblondiaux.vinted4j.utils;

import me.rochblondiaux.vinted4j.VintedClient;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class CookiesInterceptor implements Interceptor {

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if (originalResponse.headers("Set-Cookie").isEmpty())
            return originalResponse;
        originalResponse.headers("Set-Cookie")
                .forEach(s -> {
                    String[] cookies = s.split(";");
                    for (String cookie : cookies) {
                        String[] parts = cookie.split("=");
                        if (parts.length == 2) {
                            String key = parts[0].trim();
                            String value = parts[1].trim();

                            switch (key) {
                                case "anon_id" -> VintedClient.get().setAnonId(value);
                            }
                        }
                    }
                });
        return originalResponse;
    }
}
