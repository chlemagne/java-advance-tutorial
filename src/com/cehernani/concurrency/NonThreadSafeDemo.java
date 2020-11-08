package com.cehernani.concurrency;

import com.cehernani.concurrency.nonthreadsafe.DownloadFileTaskLocks;
import com.cehernani.concurrency.nonthreadsafe.DownloadStatusLocks;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class NonThreadSafeDemo {

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

    public static void show2() {

        Collection<Integer> syncedCollection = Collections.synchronizedCollection(new ArrayList<>());

        /*
            Concurrent Collections.
                These objects are better than synchronized collection because synchronization
                can cause problems when dealing with too many threads. Hence, use concurrent collections instead.
         */
        Map<String, Integer> concurrentMap = new ConcurrentHashMap<>(); // thread-safe
        concurrentMap.put("a", 1);
        concurrentMap.put("b", 2);

        Thread thread1 = new Thread(() -> {
            syncedCollection.addAll(Arrays.asList(1, 2, 3));
        });

        Thread thread2 = new Thread(() -> {
            syncedCollection.addAll(Arrays.asList(4, 5, 6));
        });

        Thread thread3 = new Thread(() -> {
            syncedCollection.addAll(Arrays.asList(7, 8, 9));
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(syncedCollection);
    }
}
