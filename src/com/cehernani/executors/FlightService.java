package com.cehernani.executors;

import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class FlightService {

    final List<String> SOURCES = List.of(
        "http://pal.airlines.com.ph/tickets",
        "http://cebupacific.com.ph/quotation",
        "http://airasia.com.ph/quote"
    );

    public Stream<CompletableFuture<Quote>> getQuotes() {
        return SOURCES.stream().map(this::getQuote);
    }

    public CompletableFuture<Quote> getQuote(String site) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting a quote from " + site);
            SecureRandom random = new SecureRandom();
            double price = 100 + random.nextInt(10);
            RandomLongTask.simulate();

            return new Quote(site, price);
        });
    }


}
