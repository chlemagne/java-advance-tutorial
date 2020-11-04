package com.cehernani;

import com.cehernani.concurrency.DownloadFileTask;

public class Main {

    public static void main(String[] args) {
	    // write your code here

        System.out.printf("Main: %s%n", Thread.currentThread().getName());
        System.out.println(Thread.activeCount());   // 2: one for main() and one for Java's garbage collector
        System.out.println(Runtime.getRuntime()
                .availableProcessors());            // 4: four available threads
        System.out.printf("###%n%n");

        Thread thread = new Thread(new DownloadFileTask());
        thread.start(); // new thread different from the main() thread

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
