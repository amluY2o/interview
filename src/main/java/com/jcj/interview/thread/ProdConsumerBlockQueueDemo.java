package com.jcj.interview.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProdConsumerBlockQueueDemo {

    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<String>(10));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "：生产线程已启动");
            try {
                myResource.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "producer").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "：消费线程已启动");
            try {
                myResource.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer").start();


        try {
            TimeUnit.SECONDS.sleep(20L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myResource.stop();
    }


}

class MyResource {
    private volatile boolean flag = true;

    private AtomicInteger atomicInteger = new AtomicInteger();

    private BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void producer() throws InterruptedException {
        String data = null;
        boolean returnValue;
        while (flag) {
            data = String.valueOf(atomicInteger.incrementAndGet());
            returnValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (returnValue) {
                System.out.println(Thread.currentThread().getName() + "：插入队列数据成功：" + data);
            } else {
                System.out.println(Thread.currentThread().getName() + "：插入队列数据失败：" + data);
            }
            TimeUnit.SECONDS.sleep(1L);
        }
        System.out.println(Thread.currentThread().getName() + "：停止生产，标识flag=" + flag);
    }

    public void consumer() throws InterruptedException {
        String result = null;
        while (flag) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (result == null || "".equalsIgnoreCase(result)) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "：超过2s没有取到，消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "：消费队列数据成功：" + result);
        }
    }

    public void stop() {
        flag = false;
    }
}
