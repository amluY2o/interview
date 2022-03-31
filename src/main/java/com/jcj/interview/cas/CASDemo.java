package com.jcj.interview.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(100);

        System.out.println(atomicInteger.compareAndSet(100, 101) + "\t current data = " + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(100, 2020) + "\t current data = " + atomicInteger.get());

    }
}
