package com.cehernani.concurrency;

import java.security.SecureRandom;

/**
 * Blocking object that completes at a random period of time.
 */
public class RandomLongTask {

    private static SecureRandom random = new SecureRandom();

    public static void simulate() {
        try {
            Thread.sleep((1 + random.nextInt(9)) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
