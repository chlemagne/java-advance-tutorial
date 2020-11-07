package com.cehernani.concurrency.confinement;

import com.cehernani.concurrency.DownloadStatus;

public class DownloadStatusConfinement implements DownloadStatus {

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
