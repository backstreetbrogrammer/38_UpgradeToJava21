package com.backstreetbrogrammer.loom.virtualThreads;

import java.util.concurrent.TimeUnit;

public class Order {
    public Order() {
    }

    public Order(final Request request) {
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (final InterruptedException e) {
            System.err.println(request);
            throw new RuntimeException(e);
        }
    }

    public synchronized Order validate(final Order validatedOrder) {
        return validatedOrder;
    }

    public synchronized Order enrich(final Order enrichedOrder) {
        return enrichedOrder;
    }

    public synchronized Order persist(final Order persistedOrder) {
        return persistedOrder;
    }

    public void sendToDownstream() {
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (final InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
