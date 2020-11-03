package com.cehernani.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
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
                // Pagination (slicing) example below
                // page 1
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20),
                // page 2
                new Movie("d", 13),
                new Movie("e", 27),
                new Movie("f", 18),
                // page 3
                new Movie("g", 11),
                new Movie("h", 16),
                new Movie("i", 29)
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

        // Another example for Movie
        movies.stream()
              .map(movie -> movie.getTitle())
              .forEach(title -> System.out.println(title));

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
              .limit(10)
              .forEach(index -> System.out.println(index));

        // Another example
        Stream<List<Integer>> stream = Stream.of(
            List.of(1, 2, 3),
            List.of(4, 5, 6)
        );
        stream.forEach(list -> System.out.println(list));

        // Another example (flatMap)
        stream.flatMap(list -> list.stream())
              .forEach(number -> System.out.println(number));

        /* Another example (slicing)
            Methods:
                - limit(n)
                - skip(n)
                - takeWhile(predicate)
                - dropWhile(predicate)

            Pagination Example:
                - total movies = totalMovies = 1000
                - movies per page = pageSize = 10 movies per page

                skipValue = (currPage - 1) * pageSize;
                limitValue = pageSize
         */
        final int PAGE_SIZE = 3;
        BinaryOperator<Integer> getSkipValue = (currPage, pageSize) -> (currPage - 1) * pageSize;
        List<Movie> page2 = movies.stream()
                                .skip(getSkipValue.apply(2, PAGE_SIZE))
                                .limit(PAGE_SIZE)
                                .collect(Collectors.toList());
        System.out.println(page2);
    }
}
