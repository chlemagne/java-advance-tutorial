package com.cehernani.exceptions;

import java.io.FileReader;

public class ExceptionsDemo {
    public static void show() {
        var reader = new FileReader("file.txt");
        System.out.println("File opened");
    }
}
