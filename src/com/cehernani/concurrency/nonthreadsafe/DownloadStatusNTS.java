package com.cehernani.concurrency.nonthreadsafe;

import com.cehernani.concurrency.DownloadStatus;

public class DownloadStatusNTS implements DownloadStatus {

    private int totalBytes;

    @Override
    public int getTotalBytes() {
        return totalBytes;
    }

    @Override
    public void incrementTotalBytes() {
        totalBytes++;
    }
}
