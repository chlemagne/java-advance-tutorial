package com.cehernani.generics;

/**
 * Non-generic classes can have generic methods.
 */
public class Utils {

    /*
        Generic method syntax:
            1. Regular Java method specifiers (e.g. public/private, static)
            2. <T> or <T extends ConstraintClass_1<T> & ConstraintClass_2<T>>
            3. Return type
            4. method name
            5. method parameters
     */
    public static <T extends Comparable<T>> T max(T first, T second) {
        return (first.compareTo(second) > 0) ? first : second;
    }
}
