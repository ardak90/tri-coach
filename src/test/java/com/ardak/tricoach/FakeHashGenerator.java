package com.ardak.tricoach;

import java.util.concurrent.atomic.AtomicInteger;

public final class FakeHashGenerator {
    private static final AtomicInteger COUNTER = new AtomicInteger(1);


    public static String nextFakeHash() {
        return String.format("%064x", COUNTER.getAndIncrement());
    }
}
