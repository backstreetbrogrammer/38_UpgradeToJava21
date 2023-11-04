package com.backstreetbrogrammer.loom.virtualThreads;

import java.util.concurrent.TimeUnit;

public class WaitUtil {

    private WaitUtil() {
    }

    public static void waitForOneSecond(final Request... request) {
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (final InterruptedException e) {
            if (request != null && request.length > 0) {
                System.err.println(request[0]);
            }
            throw new RuntimeException(e);
        }
    }

}
