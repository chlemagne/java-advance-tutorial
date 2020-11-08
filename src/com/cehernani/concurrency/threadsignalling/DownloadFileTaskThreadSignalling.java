package com.cehernani.concurrency.threadsignalling;

import com.cehernani.concurrency.DownloadFileTask;

public class DownloadFileTaskThreadSignalling implements DownloadFileTask {

    private DownloadStatusThreadSignalling status;

    public DownloadFileTaskThreadSignalling(DownloadStatusThreadSignalling status) {
        this.status = status;
    }

    @Override
    public void run() {

        System.out.println("Downloading 10,000 bytes of file...");

        for (int byte_ = 0; byte_ < 1_000_000_000; byte_++)
            status.incrementTotalBytes();

        status.done();
        synchronized (status) {
            status.notifyAll();
        }
        System.out.println("Download complete!");
    }
}
