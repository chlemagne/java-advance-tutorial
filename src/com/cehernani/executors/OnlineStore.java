package com.cehernani.executors;

import java.util.concurrent.CompletableFuture;

public class OnlineStore {

    private static final String API_URL = "http://onlinestore.com/api/";
    private static final double PRODUCT_A_PRICE = 82.5;

    private static double getProductPrice(int productId) {
        System.out.println("Retrieving product price from " + API_URL + productId);
        RandomLongTask.simulate();
        System.out.println("\tResult: $" + PRODUCT_A_PRICE);
        return PRODUCT_A_PRICE;
    }

    public static CompletableFuture<Double> getProductPriceAsync(int productID) {
        return CompletableFuture.supplyAsync(() -> getProductPrice(productID));
    }
}
