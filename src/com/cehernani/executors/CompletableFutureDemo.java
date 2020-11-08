package com.cehernani.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Supplier;

public class CompletableFutureDemo {

    public static void show1() {

        // Returns void
        Runnable runnable = () -> System.out.println("Hello, world!");
        // Signature #1, uses ForkJoinPool.commonPool(); no need to manually create executors
        Future<Void> voidFuture = CompletableFuture.runAsync(runnable);

        // Returns a value/object
        Supplier supplier = () -> 1;
        Future<Integer> future = CompletableFuture.supplyAsync(supplier);

        // blocking method
        try {
            int intResult = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void show2() {

        // Asynchronous API
        MailService service = new MailService();
        service.sendAsync();
        System.out.println("Hello, world!");

        // In real world applications, method main() runs indefinitely. Hence, add delay to see mail success result.
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
