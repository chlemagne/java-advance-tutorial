package com.cehernani.concurrency.atomic;

import com.cehernani.concurrency.DownloadStatus;

import java.util.concurrent.atomic.AtomicInteger;

public class DownloadStatusAtomic implements DownloadStatus {

    /*
        Atomic objects allows multiple threads to change this variable CONCURRENTLY.
        This is accomplished by a CPU operation called "Compare & Swap" which is
        executed a SINGLE UNINTERRUPTIBLE operation, and is also called an ATOMIC OPERATION.

        Atomic objects are ideally used for counters because it can quickly perform
        the increment operation.

        However, Adders objects should be used when multiple threads update a value because
        it is faster than Atomic objects.
     */
    private AtomicInteger totalBytes = new AtomicInteger();

    @Override
    public int getTotalBytes() {
        return totalBytes.get();
    }

    @Override
    public void incrementTotalBytes() {
        totalBytes.incrementAndGet();
    }
}
