package com.jcj.interview.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者模型(Lock)
 * 题目：一个初始值为0的变量，两个线程对其交替操作，一个加一个减，来5轮
 */

class ProdConsumerTraditionTest{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment(){
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrement(){
        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class ProdConsumerTraditionDemo {
    public static void main(String[] args) {
        ProdConsumerTraditionTest test = new ProdConsumerTraditionTest();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                test.increment();
            }
        },"A").start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                test.decrement();
            }
        },"B").start();
    }
}
