package com.cehernani.concurrency;

import java.security.SecureRandom;
import java.util.function.Supplier;

public class DownloadFileTask implements Runnable {

    private SecureRandom random = new SecureRandom();
    private Supplier<Integer> randomMilli = () -> (1 + random.nextInt(9)) * 1000;

    @Override
    public void run() {
        System.out.printf("DOWNLOADING file using <%s>...%n",
                Thread.currentThread().getName());

        try {
            Thread.sleep(randomMilli.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("COMPLETED downloading file using <%s>!!!%n",
                Thread.currentThread().getName());
    }
}
