package com.cehernani.exceptions;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionsDemo {
    public static void show() {

        try (
            var writer = new FileWriter("...");
            var reader = new FileReader("file.txt"); // reader.close() will be automatically called
        ) {
            var value = reader.read();
            new SimpleDateFormat().parse("");
        } catch(IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static void show2() throws IOException{
        var account = new Account();
        try {
            account.deposit(-1);
        } catch (IOException e) {
            System.out.println("Logging");
            throw e;
        }
    }
}
