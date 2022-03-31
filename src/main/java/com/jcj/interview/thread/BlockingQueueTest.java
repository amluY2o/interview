package com.jcj.interview.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.offer("a",2L, TimeUnit.SECONDS);
        blockingQueue.offer("b",2L, TimeUnit.SECONDS);
        blockingQueue.offer("c",2L, TimeUnit.SECONDS);
        System.out.println("ArrayBlockingQueue full");
        blockingQueue.offer("x",2L, TimeUnit.SECONDS);

//        blockingQueue.put("a");
//        blockingQueue.put("b");
//        blockingQueue.put("c");
//        //System.out.println("Queue full");
//        //blockingQueue.put("x");
//
//
//        blockingQueue.take();
//        blockingQueue.take();
//        blockingQueue.take();
//        //blockingQueue.take();


//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("b"));
//        System.out.println(blockingQueue.offer("c"));
//        System.out.println(blockingQueue.offer("x"));
//
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());

//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("x"));


    }
}
