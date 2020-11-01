package com.cehernani.lambdas;

/**
 * Definitions:
 *
 * 1. Functional Interface
 *      - An interface with a single abstract method (e.g. Comparable, Comparator)
 */
public class LambdasDemo {

    public static void show1() {
        greet(new ConsolePrinter());
    }

    public static void greet(Printer printer) {
        printer.print("Hello, world!");
    }
}
