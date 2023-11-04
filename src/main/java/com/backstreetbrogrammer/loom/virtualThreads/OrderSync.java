package com.backstreetbrogrammer.loom.virtualThreads;

import static com.backstreetbrogrammer.loom.virtualThreads.WaitUtil.waitForOneSecond;

public class OrderSync {
    public OrderSync() {
    }

    public OrderSync(final Request request) {
        waitForOneSecond(request);
    }

    public synchronized OrderSync validate(final OrderSync validatedOrder) {
        // validation logic...
        return validatedOrder;
    }

    public synchronized OrderSync enrich(final OrderSync enrichedOrder) {
        // enrichment logic...
        return enrichedOrder;
    }

    public synchronized OrderSync persist(final OrderSync persistedOrder) {
        // persistence logic...
        return persistedOrder;
    }

    public synchronized void sendToDownstream() {
        // connection logic to downstream...
        waitForOneSecond();
    }
}
