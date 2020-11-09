package com.cehernani;

import com.cehernani.executors.FlightService;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        System.out.println("Problem #1");
        FlightService service = new FlightService();
        LocalTime start = LocalTime.now();

        List<CompletableFuture<Void>> futures = service.getQuotes()
                                                    .map(future -> future.thenAccept(System.out::println))
                                                    .collect(Collectors.toList());

        CompletableFuture
            .allOf(futures.toArray(new CompletableFuture[0]))
            // then run on main thread; no need to run asynchronously
            .thenRun(() -> {
                LocalTime end = LocalTime.now();
                Duration duration = Duration.between(start, end);
                System.out.println("Finished in " + duration.toSeconds() + " sec.");
            });

        // to see in console, wait for asynchronous tasks to finish
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
