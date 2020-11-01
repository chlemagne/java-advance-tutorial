package com.cehernani.lambdas;

/**
 * Definitions:
 *
 * 1. Functional Interface
 *      - An interface with a single abstract method (e.g. Comparable, Comparator)
 *
 * Variable Capture: Anonymous Inner Class vs. Lambda Expression
 *
 * ---------------------+-----------------------+-------------------
 *       Aspects        | Anonymous Inner Class | Lambda Expression
 * =====================+=======================+===================
 * this                 | inner class           | parent class
 * ---------------------+-----------------------+-------------------
 * has access to parent |                       |
 * class fields and     | no                    | yes
 * other variables?     |                       |
 * ---------------------+-----------------------+-------------------
 *
 */
public class LambdasDemo {

    public static void show1() {

        /*
            Lambda Expression:

            Syntax:
            1. ``->`` represents the lambda operator
            2. String can be omitted since Java compiler would know the type of ``message`` using the signature of
                functional interface Printer (expressed in line 38 below).
            3. Parentheses can be removed. It is only used when:
                a. The lambda expression has no parameters.
                b. The lambda expression has multiple parameters.
            4. Curly braces can be removed if the lambda expression's body only contains one line/statement.

            Simplified syntax below:
            >> greet(message -> System.out.println(message));

         */
        greet(System.out::println);

        // other possibilities
        Printer printer1 = new ConsolePrinter(); // concrete implementation
        Printer printer2 = message -> System.out.println(message);
    }

    public static void greet(Printer printer) {
        printer.print("Hello, world!");
    }
}
