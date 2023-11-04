package com.backstreetbrogrammer.loom.virtualThreads;

import static com.backstreetbrogrammer.loom.virtualThreads.WaitUtil.waitForOneSecond;

public class OrderStatePersist {
    public static Order persist(final Request request) {
        waitForOneSecond(request);

        return new Order();
    }
}
