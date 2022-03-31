package com.jcj.interview.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

class ProducerConsumerDemo{
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<String> blockingQueue;

    public ProducerConsumerDemo(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    public void producer() throws InterruptedException{
        String value = null;
        boolean offer;
        while (flag){
            value = atomicInteger.incrementAndGet() + "";
            offer = blockingQueue.offer(value, 2L, TimeUnit.SECONDS);
            if(offer){
                System.out.println(Thread.currentThread().getName() + "\t 生产者生产：" + value);
            }else{
                System.out.println(Thread.currentThread().getName() + "\t 生产者生产失败");
            }
            TimeUnit.SECONDS.sleep(1L);
        }
        System.out.println(Thread.currentThread().getName() + "\t 生产者停止生产");
    }

    public void consumer() throws InterruptedException {
        String result = null;
        while (flag){
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(result == null || "".equals(result)){
                flag = false;
                System.out.println(Thread.currentThread().getName() + "\t 消费者消费失败");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费者消费：" + result);
        }
    }
}


public class Test {
    public static void main(String[] args) {
        ProducerConsumerDemo demo = new ProducerConsumerDemo(new ArrayBlockingQueue<String>(10));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "：生产线程已启动");
            try {
                demo.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"producer").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "：消费线程已启动");
            try {
                demo.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"consumer").start();

        try {
            TimeUnit.SECONDS.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
