package com.cehernani.lambdas;

import java.util.function.Function;

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
public class DemoFunctionInterface {

    public static void show1() {

        Function<String, Integer> map = string -> string.length();
        int length = map.apply("Hello, world!"); // 13
    }
}
