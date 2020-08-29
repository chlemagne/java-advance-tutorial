package com.cehernani.exceptions;

public class Account {

    public void deposit(float value) {

        /* data validation logic
            - defensive programming
            - used when building a library or framework that receives input from users or external systems
            - otherwise, methods within an application should trust each other
         */
        if (value <= 0)
            throw new IllegalArgumentException(); // unchecked or runtime exception
    }
}
