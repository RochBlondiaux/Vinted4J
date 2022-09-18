package me.rochblondiaux.vinted4j;

import me.rochblondiaux.vinted4j.http.request.catalog.SearchRequest;
import me.rochblondiaux.vinted4j.model.catalog.Search;

public class Vinted4JLauncher {

    public static void main(String[] args) {
        System.out.println("Starting....");
        new VintedClient.Builder()
                .username("iskiwix@gmail.com")
                .password("Roch1704")
                .build()
                .login()
                .exceptionally(throwable -> {
                    System.out.println("Error: " + throwable.getMessage());
                    return null;
                })
                .thenAccept(client1 -> {
                    System.out.println("Logged in!");

                    System.out.println("Searching for 'nike'...");
                    long start = System.currentTimeMillis();
                    client1.sendRequest(new SearchRequest(new Search.Builder()
                                    .query("nike")
                                    .build()))
                            .exceptionally(throwable -> {
                                System.out.println("Error: " + throwable.getMessage());
                                return null;
                            })
                            .thenAccept(searchResponse -> {
                                System.out.println("Found " + searchResponse.getItems().size() + " items in " + (System.currentTimeMillis() - start) + "ms !");
                            });
                });


    }
}
