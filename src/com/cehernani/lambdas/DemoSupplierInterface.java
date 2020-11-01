package com.cehernani.lambdas;

import java.util.function.Supplier;

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
public class DemoSupplierInterface {

    public static void show1() {

        Supplier<Double> getRandom = () -> Math.random(); // no need to include ``return`` keyword

        Double random = getRandom.get(); // lazy evaluation; the definition of getRandom.get() is declared in line 19.
    }
}
