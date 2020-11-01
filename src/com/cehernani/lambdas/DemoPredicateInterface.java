package com.cehernani.lambdas;

import java.util.function.Predicate;

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
public class DemoPredicateInterface {

    public static void show1() {

        String inputString1 = "Hello, world!";
        String inputString2 = "{key=value";
        Predicate<String> isLongerThan5 = string -> string.length() > 5;
        Predicate<String> hasLeftBrace = string -> string.startsWith("{");
        Predicate<String> hasRightBrace = string -> string.endsWith("{");
        Predicate<String> hasLeftAndRightBraces = hasLeftBrace.and(hasRightBrace);

        boolean result1 = isLongerThan5.test(inputString1);             // true
        boolean result2 = hasLeftAndRightBraces.test(inputString2);     // false
    }
}
