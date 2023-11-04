package com.backstreetbrogrammer.loom.virtualThreads;

import static com.backstreetbrogrammer.loom.virtualThreads.WaitUtil.waitForOneSecond;

public class ClientWallet {
    public static Order validate(final Request request) {
        waitForOneSecond(request);

        return new Order();
    }
}
