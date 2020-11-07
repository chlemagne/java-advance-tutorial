package com.cehernani.concurrency.locks;

import com.cehernani.concurrency.DownloadStatus;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatusLocks implements DownloadStatus {

    private int totalBytes;
    private Lock lock = new ReentrantLock();

    @Override
    public int getTotalBytes() {
        return totalBytes;
    }

    @Override
    public void incrementTotalBytes() {
        lock.lock();
        try {
            totalBytes++;
        } finally {
            lock.unlock();
        }
    }
}
