package com.cehernani.collections;

public class Customer implements Comparable<Customer> {

    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Customer other) {
        return this.name.compareTo(other.name);
    }
}
