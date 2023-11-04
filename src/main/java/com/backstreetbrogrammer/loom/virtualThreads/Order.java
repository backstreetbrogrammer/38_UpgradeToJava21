package com.backstreetbrogrammer.loom.virtualThreads;

import static com.backstreetbrogrammer.loom.virtualThreads.WaitUtil.waitForOneSecond;

public class Order {
    public Order() {
    }

    public Order(final Request request) {
        waitForOneSecond(request);
    }

    public Order validate(final Order validatedOrder) {
        // validation logic...
        return validatedOrder;
    }

    public Order enrich(final Order enrichedOrder) {
        // enrichment logic...
        return enrichedOrder;
    }

    public Order persist(final Order persistedOrder) {
        // persistence logic...
        return persistedOrder;
    }

    public void sendToDownstream() {
        // connection logic to downstream...
        waitForOneSecond();
    }
}
