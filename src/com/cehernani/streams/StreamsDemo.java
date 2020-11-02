package com.cehernani.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * Streams.
 *
 * To process a collection of data in a declarative way.
 *
 * Creating a stream:
 * 1. Collections
 * 2. Arrays
 * 3. Arbitrary number of objects
 *
 */
public class StreamsDemo {

    public static void show1() {

        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20)
        );
        Collection<Integer> x = new ArrayList<>();
        int[] numbers = {1, 2, 3};
        Stream<Double> randomStream = Stream.generate(() -> Math.random());

        // Imperative Programming
        int count1 = 0;
        for (Movie movie : movies) {
            if (movie.getLikes() > 10)
                count1++;
        }

        // Declarative (Functional) Programming
        long count2 = movies.stream()
                            .filter(movie -> movie.getLikes() > 10)
                            .count();

        // All class that implements the Collection<T> interface has the ability to return a stream
        x.stream();

        // Another example
        Arrays.stream(numbers)
              .forEach(n -> System.out.println(n));

        // Another example
        randomStream.limit(5)
                    .forEach(n -> System.out.println(n)); // lazy evaluation; cannot be implemented using Collection due to memory limitation

        // Another example
        Stream.iterate(1, n -> n + 1)
              .limit(10);


    }
}
