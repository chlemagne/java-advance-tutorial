package com.cehernani.concurrency.synchronization;

import com.cehernani.concurrency.DownloadStatus;

public class DownloadStatusSynchronization implements DownloadStatus {

    private int totalBytes;
    private Object totalBytesLock = new Object();

    @Override
    public int getTotalBytes() {
        return totalBytes;
    }

    @Override
    public void incrementTotalBytes() {
        synchronized (totalBytesLock) {
            totalBytes++;
        }
    }
}
