package com.cehernani.concurrency.confinement;

import com.cehernani.concurrency.DownloadFileTask;
import com.cehernani.concurrency.DownloadStatus;

public class DownloadFileTaskConfinement implements DownloadFileTask {

    private DownloadStatus status;

    public DownloadFileTaskConfinement() {
        this.status = new DownloadStatusConfinement();
    }

    @Override
    public void run() {

        System.out.println("Downloading 10,000 bytes of file...");

        for (int byte_ = 0; byte_ < 10_000; byte_++)
            status.incrementTotalBytes();

        System.out.println("Download complete!");
    }

    public DownloadStatus getStatus() {
        return status;
    }
}
