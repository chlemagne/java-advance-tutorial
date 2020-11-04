package com.cehernani;

public class Main {

    public static void main(String[] args) {
	    // write your code here

        System.out.println(Thread.activeCount());   // 2: one for main() and one for Java's garbage collector
        System.out.println(Runtime.getRuntime()
                .availableProcessors());            // 4: four available threads
    }
}
