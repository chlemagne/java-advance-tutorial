package com.cehernani.lambdas;

import java.util.List;
import java.util.function.Consumer;

/**
 * Built-in Functional Interfaces (java.util.function).
 *
 * Java general categories:
 * 1. Consumer      void consume(obj)
 * 2. Supplier      obj supply()
 * 3. Function      obj map(obj)
 * 4. Predicate     bool test(condition)
 *
 */
public class DemoConsumerInterface {

    public static void show1() {

        List<String> stringList = List.of("a", "b", "c");
        Consumer<String> print = item -> System.out.println(item);
        Consumer<String> printUpperCase = item -> System.out.println(item.toUpperCase());

        // Using Anonymous Inner Class
        stringList.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // Using imperative programming (how to do it)
        for (String item : stringList)
            System.out.println(item);

        // using lambdas and declarative programming (what to do)
        stringList.forEach(print.andThen(printUpperCase)); // chaining consumers
    }
}
