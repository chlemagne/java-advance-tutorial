package com.cehernani.executors;

import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
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

    public static void show3() {

        System.out.println(Thread.currentThread().getName());

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 1);
        future1.thenRunAsync(() -> System.out.printf("Executed in (%s).%n",
                Thread.currentThread().getName())
        );

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 3);
        future2.thenAcceptAsync(result -> {
            System.out.printf("Executed in (%s).%n",
                    Thread.currentThread().getName());
            System.out.println(result);
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void show4() {

        // error in another thread
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting the current weather...");
            throw new IllegalStateException();
        });

        // pass error to this thread but return the default value
        try {
            int temp = future1.exceptionally(ex -> 1).get();
            System.out.println(temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static int toFahrenheit(int celsius) {
        return (int) (celsius * 1.8) + 32;
    }

    public static void show5() {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 20);
        future1
            .thenApply(CompletableFutureDemo::toFahrenheit) // convert to fahrenheit
            .thenAccept(System.out::println);
    }

    public static void show6() {
        Authentication.getUserEmailAsync()
                    .thenCompose(Playlist::getPlaylistAsync)
                    .thenAcceptAsync(System.out::println);

        // to see in console, wait for asynchronous tasks to finish
        try {
            Thread.sleep(20_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void show7() {

        /*
            thenCombine second parameter (price * exchangeRate) waits for both OnlineStore.getProductPriceAsync and
            Forex.getUsdToPhpRateAsync() to complete before executing.
         */
        OnlineStore.getProductPriceAsync(17723)
                .thenCombine(Forex.getUsdToPhpRateAsync(), (price, exchangeRate) -> price * exchangeRate)
                .thenAccept((price) -> System.out.println("Price in PHP: " + price));

        // to see in console, wait for asynchronous tasks to finish
        try {
            Thread.sleep(20_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
