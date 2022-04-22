package com.jcj.interview.thread;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    private static final int SIZE = 10;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(SIZE);
        for (int i = 1; i <= SIZE; i++) {
            ThreadUtil.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教室");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t 班长最后关门走人");
    }
}
