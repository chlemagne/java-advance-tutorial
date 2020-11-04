package com.cehernani.concurrency;

public class DownloadFileTask implements Runnable {

    @Override
    public void run() {
        System.out.printf("Downloading file using <%s>...%n",
                Thread.currentThread().getName());
    }
}
