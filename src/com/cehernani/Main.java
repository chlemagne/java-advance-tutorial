package com.cehernani;

import com.cehernani.generics.GenericList;
import com.cehernani.generics.User;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        var intList = new GenericList<Integer>();
        var stringList = new GenericList<String>();
        var userList = new GenericList<User>();

        intList.add(1);                 // boxing; compiler transforms a primitive type value to reference type
        int intValue = intList.get(0);  // unboxing; opposite
        System.out.println(intValue);

        stringList.add("Hello, world!");
        String stringValue = stringList.get(0);
        System.out.println(stringValue);

        userList.add(new User());
        User user = userList.get(0);
        System.out.println(user);
    }
}
