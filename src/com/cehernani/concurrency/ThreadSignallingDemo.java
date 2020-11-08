package com.cehernani.concurrency;

import com.cehernani.concurrency.threadsignalling.DownloadFileTaskThreadSignalling;
import com.cehernani.concurrency.threadsignalling.DownloadStatusThreadSignalling;;

public class ThreadSignallingDemo {

    public static void show1() {

        DownloadStatusThreadSignalling status = new DownloadStatusThreadSignalling();

        Thread thread1 = new Thread(new DownloadFileTaskThreadSignalling(status));
        Thread thread2 = new Thread(() -> {
            //Line below is inefficient since it wastes CPU clock cycles while waiting.
            //while (!status.isDone()) {}
            while (!status.isDone()) {

                // Java VM expects the wait() method to be inside a synchronized block
                synchronized (status) {
                    try {
                        status.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(status.getTotalBytes());
        });

        thread1.start();
        thread2.start();
    }
}
