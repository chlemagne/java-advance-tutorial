package com.cehernani.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorsDemo {

    public static void show1() {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        /*
            Instead of manually creating new Thread instances, use ExecutorService object to manage
            the submitted tasks using its thread pools.
         */
        try {
            for (int i = 0; i < 10; i++) {
                // (Functional Interface) Runnable's method run() returns void.
                executor.submit(() -> {
                    System.out.printf("Performing some task at <%s>%n",
                            Thread.currentThread().getName());
                    RandomLongTask.simulate();
                });
            }
        } finally {
            executor.shutdown();
        }
    }
}
