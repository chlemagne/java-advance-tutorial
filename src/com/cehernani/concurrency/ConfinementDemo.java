package com.cehernani.concurrency;

import com.cehernani.concurrency.confinement.DownloadFileTaskConfinement;
import com.cehernani.concurrency.confinement.DownloadStatusConfinement;

import java.util.ArrayList;
import java.util.List;

public class ConfinementDemo {

    public static void show1() {

        List<Thread> threads = new ArrayList<>();
        List<DownloadFileTaskConfinement> tasks = new ArrayList<>();

        // download 10 files; store status in ``status`` object
        for (int i = 0; i < 10; i++) {
            DownloadFileTaskConfinement task = new DownloadFileTaskConfinement();
            tasks.add(task);

            Thread thread = new Thread(task);
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

        int totalBytes = tasks.stream()
                        .map(t -> t.getStatus().getTotalBytes())
                        .reduce(0, Integer::sum);

        // print total downloaded bytes
        System.out.println(totalBytes);
    }
}
