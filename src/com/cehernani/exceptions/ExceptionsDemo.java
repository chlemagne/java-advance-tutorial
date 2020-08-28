package com.cehernani.exceptions;

import java.io.FileReader;
import java.io.FileNotFoundException;

public class ExceptionsDemo {
    public static void show() {
        try {
            var reader = new FileReader("file.txt");
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
