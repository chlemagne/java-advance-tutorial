package com.cehernani.concurrency;

import com.cehernani.concurrency.locks.DownloadFileTaskLocks;
import com.cehernani.concurrency.locks.DownloadStatusLocks;

import java.util.ArrayList;
import java.util.List;

public class LocksDemo {

    public static void show1() {

        DownloadStatus status = new DownloadStatusLocks();
        List<Thread> threads = new ArrayList<>();

        // download 10 files; store status in ``status`` object
        for (int i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTaskLocks(status));
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
