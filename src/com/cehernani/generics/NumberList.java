package com.cehernani.generics;

/*
    Java generic class with constraint to Number
        java.lang.Object
            java.lang.Number
    - direct known subclasses: ..., Byte, Double, DoubleAccumulator, DoubleAdder, Float, Integer, Long, ...,
 */
public class NumberList<T extends Number> {
    private T[] items = (T[]) new Number[10]; // casting is done at runtime
    private int count;

    public void add (T item) {
        items[count++] = item;
    }

    public T get(int index) {
        return items[index];
    }
}
