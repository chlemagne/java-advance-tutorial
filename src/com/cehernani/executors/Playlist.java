package com.cehernani.executors;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class Playlist {

    private static String getPlaylist(String email) {
        System.out.println("Retrieving playlist...");
        RandomLongTask.simulate();
        return "\tFound: playlist of " + email;
    }

    public static CompletableFuture<String> getPlaylistAsync(String email) {
        return CompletableFuture.supplyAsync(() -> getPlaylist(email));
    }
}
