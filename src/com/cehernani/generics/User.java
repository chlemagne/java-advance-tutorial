package com.cehernani.generics;

/*
    How to use a generic interface (e.g. Comparable<T>)?
        1. https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
        3. implements Comparable<T>
        4. override compareTo(T o)
 */
public class User implements Comparable<User> {
    private int points;

    public User(int points) {
        this.points = points;
    }

    /**
     * compareTo
     * https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
     *
     * @param user - the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(User user) {
        return points - user.points;
    }
}
