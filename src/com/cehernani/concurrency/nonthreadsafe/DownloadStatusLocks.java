package com.cehernani.concurrency.nonthreadsafe;

import com.cehernani.concurrency.DownloadStatus;

public class DownloadStatusLocks implements DownloadStatus {

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
