package com.cehernani;

import com.cehernani.exceptions.ExceptionsDemo;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        try {
            ExceptionsDemo.show2();
        } catch(Throwable e) {
            System.out.println("An unexpected error occurred.");
        }
    }
}
