package com.cehernani.concurrency.adders;

import com.cehernani.concurrency.DownloadStatus;

import java.util.concurrent.atomic.LongAdder;

public class DownloadStatusAdders implements DownloadStatus {

    /*
        Adder objects are faster than Atomic objects. Hence, it should be
        used when multiple threads are updating a value.
     */
    private LongAdder totalBytes = new LongAdder();

    @Override
    public int getTotalBytes() {
        /*
            Internally, it will call a method sum() where it adds all the counter values.
         */
        return totalBytes.intValue();
    }

    @Override
    public void incrementTotalBytes() {
        totalBytes.increment();
    }
}
