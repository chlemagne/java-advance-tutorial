package com.cehernani.generics;

/**
 * Non-generic classes can have generic methods.
 */
public class Utils {

    /*
        Generic method syntax:
            1. Regular Java method specifiers (e.g. public/private, static)
            2. <T>, <K, V>, or <T extends ConstraintClass_1<T> & ConstraintClass_2<T>>
            3. Return type
            4. method name
            5. method parameters
     */
    public static <T extends Comparable<T>> T max(T first, T second) {
        return (first.compareTo(second) > 0) ? first : second;
    }

    public static <K, V> void print(K key, V value) {
        System.out.println(key + "=" + value);
    }

    /**
     * Wildcard Example 1 that accepts a generic class of any type.
     *
     * Java backend implementation:
     *      class CAP#1 {}
     *
     * @param param
     */
    public static void demoAnyGenericList (GenericList<?> param) {
        Object x = param.get(0);
    }
}
