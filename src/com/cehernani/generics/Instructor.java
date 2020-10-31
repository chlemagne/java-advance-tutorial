package com.cehernani.generics;

public class Instructor extends User {

    public Instructor(int points) {
        super(points);
    }

    public void teach() {
        System.out.println("Instructor teaching.");
    }
}
