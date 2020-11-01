package com.cehernani.lambdas;

/**
 * Definitions:
 *
 * 1. Functional Interface
 *      - An interface with a single abstract method (e.g. Comparable, Comparator)
 */
public class LambdasDemo {

    public static void show1() {

        // Anonymous Inner Class
        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });
    }

    public static void greet(Printer printer) {
        printer.print("Hello, world!");
    }
}
