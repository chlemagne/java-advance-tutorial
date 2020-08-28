package com.cehernani.exceptions;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class ExceptionsDemo {
    public static void show() {
        try {
            var reader = new FileReader("file.txt");
            var value = reader.read();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
