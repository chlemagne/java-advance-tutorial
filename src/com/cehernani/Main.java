package com.cehernani;

import com.cehernani.collections.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer("b"));
        customers.add(new Customer("a"));
        customers.add(new Customer("c"));

        Collections.sort(customers);    // [a, b, c]
    }
}
