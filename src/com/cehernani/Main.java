package com.cehernani;

import com.cehernani.concurrency.DownloadFileTask;

public class Main {

    public static void main(String[] args) {
	    // write your code here

        System.out.println(Thread.activeCount());   // 2: one for main() and one for Java's garbage collector
        System.out.println(Runtime.getRuntime()
                .availableProcessors());            // 4: four available threads
        System.out.printf("###%n%n");

        for (int count = 0; count < 10; count++) {
            Thread thread = new Thread(new DownloadFileTask());
            thread.start();
        }
    }
}
