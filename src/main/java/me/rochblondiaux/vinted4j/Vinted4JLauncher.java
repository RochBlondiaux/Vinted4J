package me.rochblondiaux.vinted4j;

import me.rochblondiaux.vinted4j.utils.VintedUtils;

public class Vinted4JLauncher {

    public static void main(String[] args) {
        System.out.println("Starting....");
        VintedAPI api = new VintedAPI.Builder()
                .username("iskiwix@gmail.com")
                .password("Roch1704")
                .build();

        api.login()
                .exceptionally(throwable -> {
                    throwable.printStackTrace();
                    System.out.println("Logged in as (EXCEPTIONALLY) Result: " + throwable.getMessage());
                    return null;
                })
                .thenAccept(user -> {
                    System.out.println("Logged in as " + user.getUsername());
                    user.feedbacks()
                            .exceptionally(throwable -> {
                                System.out.println("Failed to get feedbacks (EXCEPTIONALLY) Result: " + throwable.getMessage());
                                return null;
                            })
                            .thenAccept(feedbacks -> {
                                feedbacks.forEach(feedback -> {
                                    System.out.println(feedback.getContent() + " - " + feedback.getRating() + " - " + feedback.getAuthor().getUsername());
                                });
                            });
                    VintedUtils.sleepSeconds(30);
                    System.out.println("Logging out...");
                    api.logout()
                            .exceptionally(throwable -> {
                                throwable.printStackTrace();
                                return null;
                            })
                            .thenAccept(aVoid -> {
                                if (aVoid) {
                                    System.out.println("Logged out!");
                                } else {
                                    System.out.println("Failed to logout!");
                                }
                            });
                });
    }
}
