package com.cehernani.generics;

/*
    Java Generics syntax:
        1. Angle brackets, <>
        2. T is a standard that specifies the type of objects concerned
 */
public class GenericList<T> {
    private T[] items = (T[]) new Object[10]; // casting is done at runtime
    private int count;

    public void add (T item) {
        items[count++] = item;
    }

    public T get(int index) {
        return items[index];
    }
}
