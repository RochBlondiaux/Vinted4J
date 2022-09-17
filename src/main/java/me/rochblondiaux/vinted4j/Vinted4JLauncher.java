package me.rochblondiaux.vinted4j;

public class Vinted4JLauncher {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        new VintedClient.Builder()
                .username("iskiwix@gmail.com")
                .password("Roch1704")
                .build()
                .login()
                .exceptionally(throwable -> {
                    throwable.printStackTrace();
                    System.out.println("Error: " + throwable.getMessage());
                    return null;
                })
                .thenAccept(client1 -> {
                    System.out.println("Logged in!");
                });


    }
}
