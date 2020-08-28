package com.cehernani.exceptions;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionsDemo {
    public static void show() {
        FileReader reader = null;

        try {
            reader = new FileReader("file.txt");
            var value = reader.read();
            new SimpleDateFormat().parse("");
        } catch(IOException | ParseException e) {
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
