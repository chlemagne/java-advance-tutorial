package com.cehernani.executors;

import java.util.concurrent.CompletableFuture;

public class Resource {

    private static final int FILE_SIZE_BYTES = 37_283;

    private static int downloadFromURL(String url) {
        System.out.println("Downloading " + url);
        RandomLongTask.simulate();
        return FILE_SIZE_BYTES;
    }

    public static CompletableFuture<Integer> downloadFromAsync(String url) {
        return CompletableFuture.supplyAsync(() -> downloadFromURL(url));
    }
}
