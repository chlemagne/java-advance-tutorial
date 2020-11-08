package com.cehernani.executors;

import java.util.concurrent.CompletableFuture;

public class MailService {

    private static void send() {
        RandomLongTask.simulate();
        System.out.println("Mail was sent.");
    }

    /**
     * Asynchronously send mail.
     *
     * NOTE: ``Async`` suffix is a convention.
     * @return
     */
    public CompletableFuture<Void> sendAsync() {
        return CompletableFuture.runAsync(MailService::send);
    }
}