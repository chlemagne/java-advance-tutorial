package com.cehernani.lambdas;

/**
 * Example of a Functional Interface.
 *
 * Contains a SINGLE abstract method, Printer.print().
 */
public interface Printer {

    /**
     * Example of an abstract method (no implementation).
     * @param message
     */
    void print(String message);

    /**
     * Example of a default interface method with a default implementation.
     * @param message
     */
    default void printTwice(String message) {
        System.out.println(message);
        System.out.println(message);
    }
}
