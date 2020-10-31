package com.cehernani;

import com.cehernani.generics.*;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        var intList = new NumberList<Integer>();
        var stringList = new GenericList<String>();
        var userList = new GenericList<User>();

        intList.add(1);                 // boxing; compiler transforms a primitive type value to reference type
        int intValue = intList.get(0);  // unboxing; opposite
        System.out.println(intValue);

        stringList.add("Hello, world!");
        String stringValue = stringList.get(0);
        System.out.println(stringValue);

        userList.add(new User(10));
        userList.add(new User(20));
        User user = userList.get(0);
        System.out.println(user);
        int compareResult = userList.get(0).compareTo(userList.get(1));
        if (compareResult < 0)
            System.out.println("User1 < User2");

        System.out.println(Utils.max(new User(100), new User(200)));

        Utils.print(1, "Ball");

        // OK; User <--- User
        User u1 = new User(10);

        // OK; User <--- Instructor
        User u2 = new Instructor(20);

        /*
            NOK; Instructor <-/- User

            Object
                Vehicle
                    Car
                    Motorcycle
                User
                    Driver
                    Instructor

            User can be either Driver, Instructor, or something else.
         */
        // Instructor i1 = new User(30);

        // OK; Instructor <--- User
        Instructor i2 = new Instructor(40);
    }
}
