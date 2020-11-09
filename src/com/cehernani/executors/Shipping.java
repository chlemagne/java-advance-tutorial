package com.cehernani.executors;

import java.util.concurrent.CompletableFuture;

public class Shipping {

    private static final String API_URL = "http://shipping.com/api/";
    private static final int SHIPPING_DAYS_SAMPLE = 3;

    private static int getShippingEstimate(String from, String to) {
        System.out.printf("Retrieving shipping duration from %s/%s/%s%n",
                API_URL,
                from,
                to);
        RandomLongTask.simulate();
        System.out.printf("\tResult: %s days%n", SHIPPING_DAYS_SAMPLE);
        return SHIPPING_DAYS_SAMPLE;
    }

    public static CompletableFuture<Integer> getShippingEstimateAsync(String from, String to) {
        return CompletableFuture.supplyAsync(() -> getShippingEstimate(from, to));
    }
}
