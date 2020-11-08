package com.cehernani.concurrency.adders;

import com.cehernani.concurrency.DownloadFileTask;
import com.cehernani.concurrency.DownloadStatus;

public class DownloadFileTaskAdders implements DownloadFileTask {

    private DownloadStatus status;

    public DownloadFileTaskAdders(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {

        System.out.println("Downloading 10,000 bytes of file...");

        for (int byte_ = 0; byte_ < 10_000; byte_++)
            status.incrementTotalBytes();

        System.out.println("Download complete!");
    }
}
