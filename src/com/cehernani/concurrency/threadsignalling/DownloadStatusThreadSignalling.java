package com.cehernani.concurrency.threadsignalling;

import com.cehernani.concurrency.DownloadStatus;

public class DownloadStatusThreadSignalling implements DownloadStatus {

    private int totalBytes;
    /*
        Volatile keyword removes Java optimization.

        Java Caching Optimization:
            - Java puts the same data ``a`` into CPU cache 1 and 2 for fast access.

            Memory  (a=2)
            CPU 1   (a=1) -> outdated
            CPU 2   (a=2)

        Removing Caching Optimization:
            - Java will read data ``a`` DIRECTLY from memory. As a result, this will eliminate visibility across
                multiple threads.
     */
    private volatile boolean isDone = false;

    @Override
    public int getTotalBytes() {
        return totalBytes;
    }

    @Override
    public void incrementTotalBytes() {
        totalBytes++;
    }

    public void done() {
        isDone = true;
    }

    public boolean isDone() {
        return isDone;
    }
}
