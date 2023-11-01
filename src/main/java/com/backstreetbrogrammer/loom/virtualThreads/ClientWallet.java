package com.backstreetbrogrammer.loom.virtualThreads;

import java.util.concurrent.TimeUnit;

public class ClientWallet {
    public static Order validate(final Request request) {
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (final InterruptedException e) {
            System.err.println(request);
            throw new RuntimeException(e);
        }

        return new Order();
    }
}
