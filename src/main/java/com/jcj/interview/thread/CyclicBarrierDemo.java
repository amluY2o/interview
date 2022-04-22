package com.jcj.interview.thread;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    private static final int SIZE = 10;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(SIZE, () -> System.out.println("******召唤神龙"));
        for (int i = 1; i <= SIZE; i++) {
            final int tempInt = i;
            ThreadUtil.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " \t收集到第" + tempInt + "颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
