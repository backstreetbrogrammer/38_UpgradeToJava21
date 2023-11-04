package com.backstreetbrogrammer.loom.virtualThreads;

import static com.backstreetbrogrammer.loom.virtualThreads.WaitUtil.waitForOneSecond;

public class OrderNonSync {
    public OrderNonSync() {
    }

    public OrderNonSync(final Request request) {
        waitForOneSecond(request);
    }

    public OrderNonSync validate(final OrderNonSync validatedOrder) {
        // validation logic...
        return validatedOrder;
    }

    public OrderNonSync enrich(final OrderNonSync enrichedOrder) {
        // enrichment logic...
        return enrichedOrder;
    }

    public OrderNonSync persist(final OrderNonSync persistedOrder) {
        // persistence logic...
        return persistedOrder;
    }

    public void sendToDownstream() {
        // connection logic to downstream...
        waitForOneSecond();
    }
}
