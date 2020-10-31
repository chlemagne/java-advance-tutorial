package com.cehernani;

import com.cehernani.collections.Customer;
import com.cehernani.collections.EmailComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer("b", "y@gmail.com"));
        customers.add(new Customer("a", "z@gmail.com"));
        customers.add(new Customer("c", "x@gmail.com"));

        Collections.sort(customers);                // [a, b, c]
        Collections.sort(
                customers, new EmailComparator());  // [c, b, a]
    }
}
