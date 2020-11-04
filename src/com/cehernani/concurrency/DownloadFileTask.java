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

        for (var i = 0; i < Integer.MAX_VALUE; i++) {
            if (Thread.currentThread().isInterrupted()) return;
            System.out.printf("Downloading byte %d%n", i);
        }

        System.out.printf("COMPLETED downloading file using <%s>!!!%n",
                Thread.currentThread().getName());
    }
}
