package com.jcj.interview.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：多线程之间顺序调用，实现A->B->C,三个线程启动，要求如下：
 * AA打印5次，BB打印10次，CC打印15次
 * 紧接着
 * AA打印5次，BB打印10次，CC打印15次
 * ...
 * 来10轮
 */
class SyncAndReentrandLockTest{
    //A:1 B:2 C:3
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print(int count){
        lock.lock();
        try {
            if(count == 5){
                while(number != 1){
                    c1.await();
                }
                for (int i = 1; i <= count; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                }
                number = 2;
                c2.signal();
            }else if (count == 10){
                while(number != 2){
                    c2.await();
                }
                for (int i = 1; i <= count; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                }
                number = 3;
                c3.signal();
            }else if(count == 15){
                while(number != 3){
                    c3.await();
                }
                for (int i = 1; i <= count; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                }
                number = 1;
                c1.signal();
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


}
public class SyncAndReentrandLockDemo {
    public static void main(String[] args) {
        SyncAndReentrandLockTest test = new SyncAndReentrandLockTest();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                test.print(5);
            }
        },"A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                test.print(10);
            }
        },"B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                test.print(15);
            }
        },"C").start();
    }
}
