package com.cehernani.generics;

import java.util.Iterator;

/*
    Java Generics syntax:
        1. Angle brackets, <>
        2. T is a standard that specifies the type of objects concerned
 */
public class GenericList<T> implements Iterable<T> {

    private T[] items = (T[]) new Object[10]; // casting is done at runtime
    private int count;

    public void add (T item) {
        items[count++] = item;
    }

    public T get(int index) {
        return items[index];
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new CustomListIterator(this);
    }

    private class CustomListIterator implements Iterator<T> {

        private GenericList<T> list;
        private int index;

        public CustomListIterator(GenericList<T> list) {
            this.list = list;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return (index < list.count);
        }

        @Override
        public T next() {
            return list.items[index++];
        }
    }
}
