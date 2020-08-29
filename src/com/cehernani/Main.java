package com.cehernani;

import com.cehernani.generics.List;
import com.cehernani.generics.User;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        var list = new List();

        // append objects
        list.add(1);                    // index 0; Java compiler transforms this line to line below
        list.add(Integer.valueOf(1));   // index 1;
        list.add("Hello, world!");      // index 2;
        list.add(new User());           // index 3;

        // retrieve objects
        int firstValue = (int) list.get(0); // explicit cast object to primitive type integer
        int thirdValue = (int) list.get(2); // PROBLEM: unchecked exception; index 2 returns a String object and cannot
                                            // be casted to integer; Java will raise ClassCastException on runtime;
                                            // Java Generics handles these errors on compile-time as checked exceptions.
    }
}
