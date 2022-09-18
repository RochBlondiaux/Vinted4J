package me.rochblondiaux.vinted4j;

import me.rochblondiaux.vinted4j.model.events.authentification.LoginEvent;
import me.rochblondiaux.vinted4j.model.events.authentification.LogoutEvent;
import me.rochblondiaux.vinted4j.model.events.authentification.PreLoginEvent;

public class Vinted4JLauncher {

    public static void main(String[] args) {
        System.out.println("Starting....");
        VintedAPI api = new VintedAPI.Builder()
                .username("iskiwix@gmail.com")
                .password("Roch1704")
                .build();
        api.getEventManager()
                .onEvent(PreLoginEvent.class, preLoginEvent -> System.out.println("PreLoginEvent"));
        api.getEventManager()
                .onEvent(LoginEvent.class, event -> System.out.println("Logged in as (EVENT) Result: " + event.getResult().name()));
        api.getEventManager()
                .onEvent(LogoutEvent.class, logoutEvent -> {
                    System.out.println("Logged out (EVENT)");
                    System.exit(0);
                });
        api.login()
                .exceptionally(throwable -> {
                    throwable.printStackTrace();
                    System.out.println("Logged in as (EXCEPTIONALLY) Result: " + throwable.getMessage());
                    return null;
                })
                .thenAccept(user -> {
                    System.out.println("Logged in as " + user.getUsername());
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
