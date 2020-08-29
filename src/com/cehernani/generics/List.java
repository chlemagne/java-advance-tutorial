package com.cehernani.generics;

/*
    Poor Solution to enable classes and
    interfaces (i.e. types) to be parameters.
*/
public class List {
    private Object[] items = new Object[10];
    private int count;

    public void add(Object item) {
        items[count++] = item;
    }

    public Object get(int index) {
        return items[index];
    }
}
