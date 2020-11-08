package com.cehernani.concurrency.volatile_;

import com.cehernani.concurrency.DownloadFileTask;

public class DownloadFileTaskVolatile implements DownloadFileTask {

    private DownloadStatusVolatile status;

    public DownloadFileTaskVolatile(DownloadStatusVolatile status) {
        this.status = status;
    }

    @Override
    public void run() {

        System.out.println("Downloading 10,000 bytes of file...");

        for (int byte_ = 0; byte_ < 1_000_000_000; byte_++)
            status.incrementTotalBytes();

        status.done();
        System.out.println("Download complete!");
    }
}
