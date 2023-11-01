package com.backstreetbrogrammer.loom.virtualThreads;

import java.util.concurrent.TimeUnit;

public class OrderStatePersist {
    public static Order persist(final Request request) {
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (final InterruptedException e) {
            System.err.println(request);
            throw new RuntimeException(e);
        }

        return new Order();
    }
}
