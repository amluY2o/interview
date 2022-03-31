package com.jcj.interview.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueTest {

    public static void main(String[] args){
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + ": put 1");
                blockingQueue.put("1");

                System.out.println(Thread.currentThread().getName() + ": put 2");
                blockingQueue.put("2");

                System.out.println(Thread.currentThread().getName() + ": put 3");
                blockingQueue.put("3");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5L);
                System.out.println(Thread.currentThread().getName()+ ": " + blockingQueue.take());

                TimeUnit.SECONDS.sleep(5L);
                System.out.println(Thread.currentThread().getName()+ ": " + blockingQueue.take());

                TimeUnit.SECONDS.sleep(5L);
                System.out.println(Thread.currentThread().getName()+ ": " + blockingQueue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
