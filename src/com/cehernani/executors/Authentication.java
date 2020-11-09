package com.cehernani.executors;

import java.util.concurrent.CompletableFuture;

public class Authentication {

    final static String EMAIL_SAMPLE = "xyz@gmail.com";

    private static String getUserEmail() {
        System.out.println("Retrieving email...");
        RandomLongTask.simulate();
        System.out.println("\tFound: " + EMAIL_SAMPLE);
        return EMAIL_SAMPLE;
    }

    public static CompletableFuture<String> getUserEmailAsync() {
        return CompletableFuture.supplyAsync(Authentication::getUserEmail);
    }
}
