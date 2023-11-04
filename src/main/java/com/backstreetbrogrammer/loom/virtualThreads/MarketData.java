package com.backstreetbrogrammer.loom.virtualThreads;

import static com.backstreetbrogrammer.loom.virtualThreads.WaitUtil.waitForOneSecond;

public class MarketData {
    public static Order enrich(final Request request) {
        waitForOneSecond(request);

        return new Order();
    }
}
