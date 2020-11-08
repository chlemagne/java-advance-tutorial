package com.cehernani.executors;

import java.util.concurrent.*;

public class ExecutorsDemo {

    public static void show1() {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        /*
            Instead of manually creating new Thread instances, use ExecutorService object to manage
            the submitted tasks using its thread pools.
         */
        try {
            // (Functional Interface) Callable's method call() returns a value/object.
            Future<Integer> future = executor.submit(() -> {
                RandomLongTask.simulate();
                return 1;
            });
            System.out.printf("Doing more work...%n%n");

            for (int i = 0; i < 10; i++) {
                // (Functional Interface) Runnable's method run() returns void.
                executor.submit(() -> {
                    System.out.printf("Performing some task at <%s>%n",
                            Thread.currentThread().getName());
                    RandomLongTask.simulate();
                });
            }

            System.out.printf("Waiting for the result...%n");
            try {
                // Future get() is a blocking (synchronous) method
                int result = future.get();
                System.out.printf("Result: %d%n%n", result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }


        } finally {
            executor.shutdown();
        }
    }
}
