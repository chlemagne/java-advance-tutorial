package com.cehernani.concurrency;

import com.cehernani.concurrency.adders.*;

import java.util.ArrayList;
import java.util.List;

public class AddersDemo {

    public static void show1() {

        DownloadStatus status = new DownloadStatusAdders();
        List<Thread> threads = new ArrayList<>();

        // download 10 files; store status in ``status`` object
        for (int i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTaskAdders(status));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // print total downloaded bytes
        System.out.println(status.getTotalBytes());
    }
}
