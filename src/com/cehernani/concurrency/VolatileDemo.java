package com.cehernani.concurrency;

import com.cehernani.concurrency.volatile_.DownloadFileTaskVolatile;
import com.cehernani.concurrency.volatile_.DownloadStatusVolatile;

public class VolatileDemo {

    public static void show1() {

        DownloadStatusVolatile status = new DownloadStatusVolatile();

        Thread thread1 = new Thread(new DownloadFileTaskVolatile(status));
        Thread thread2 = new Thread(() -> {
            while (!status.isDone()) {}
            System.out.println(status.getTotalBytes());
        });

        thread1.start();
        thread2.start();
    }
}
