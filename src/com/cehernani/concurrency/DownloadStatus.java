package com.cehernani.concurrency;

public interface DownloadStatus {

    /**
     * Return total downloaded bytes.
     * @return
     */
    public int getTotalBytes();

    /**
     * Increment total downloaded bytes.
     */
    public void incrementTotalBytes();
}
