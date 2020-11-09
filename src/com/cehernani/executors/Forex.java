package com.cehernani.executors;

import java.util.concurrent.CompletableFuture;

public class Forex {

    private static final String API_URL = "http://forex.com/api/";
    private static final double USD_PHP_EX_RATE = 48.9;

    private static double getUsdToPhpRate() {
        System.out.println("Retrieving conversion rate from " + API_URL + "usd/php");
        RandomLongTask.simulate();
        System.out.println("\tConversion Factor: " + USD_PHP_EX_RATE);
        return USD_PHP_EX_RATE;
    }

    public static CompletableFuture<Double> getUsdToPhpRateAsync() {
        return CompletableFuture.supplyAsync(Forex::getUsdToPhpRate);
    }
}
