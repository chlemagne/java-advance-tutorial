package com.cehernani.lambdas;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Built-in Functional Interfaces (java.util.function).
 *
 * Java general categories:
 * 1. Consumer      void consume(obj)
 * 2. Supplier      obj supply()
 * 3. Function      obj map(obj)
 *      -UnaryOperator
 *      -BinaryOperator
 * 4. Predicate     bool test(condition)
 *
 */
public class DemoFunctionInterface {

    public static void show1() {

        Function<String, Integer> map = string -> string.length();
        UnaryOperator<Integer> square = a -> a * a;
        UnaryOperator<Integer> increment = a -> a + 1;
        BinaryOperator<Integer> add = (a, b) -> a + b;

        int length = map.apply("Hello, world!"); // 13
        int result = add.andThen(increment).andThen(square).apply(1, 1); // 9
    }
}
