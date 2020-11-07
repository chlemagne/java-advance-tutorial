package com.cehernani.concurrency;

import com.cehernani.concurrency.nonthreadsafe.DownloadFileTaskNTS;
import com.cehernani.concurrency.nonthreadsafe.DownloadStatusNTS;

import java.util.ArrayList;
import java.util.List;

public class NonThreadSafeDemo {

    public static void show1() {

        DownloadStatus status = new DownloadStatusNTS();
        List<Thread> threads = new ArrayList<>();

        // download 10 files; store status in ``status`` object
        for (int i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTaskNTS(status));
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
