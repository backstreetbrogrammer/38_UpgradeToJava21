package com.backstreetbrogrammer.loom.virtualThreads;

import static com.backstreetbrogrammer.loom.virtualThreads.WaitUtil.waitForOneSecond;

public class Order {
    public Order() {
    }

    public Order(final Request request) {
        waitForOneSecond(request);
    }

    public synchronized Order validate(final Order validatedOrder) {
        // validation logic...
        return validatedOrder;
    }

    public synchronized Order enrich(final Order enrichedOrder) {
        // enrichment logic...
        return enrichedOrder;
    }

    public synchronized Order persist(final Order persistedOrder) {
        // persistence logic...
        return persistedOrder;
    }

    public synchronized void sendToDownstream() {
        // connection logic to downstream...
        waitForOneSecond();
    }
}
