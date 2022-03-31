package com.jcj.interview.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportDemo {

    static Object lockObject = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        //syschronizedWaitNotify();
        //lockAwaitSignal();

        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t-----come in");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t-----被唤醒");
        }, "A");
        a.start();
        new Thread(()->{
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName() + "\t-----通知");
        },"B").start();
    }

    private static void lockAwaitSignal() {
        new Thread(() -> {
            //try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + "\t-----come in");
            lock.lock();
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "\t-----被唤醒");
        }, "A").start();

        new Thread(() -> {
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t-----通知");
            } finally {
                lock.unlock();
            }
        }, "B").start();
    }

    private static void syschronizedWaitNotify() {
        new Thread(() -> {
            //try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            synchronized (lockObject) {
                System.out.println(Thread.currentThread().getName() + "\t-----come in");
                try {
                    lockObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t-----被唤醒");
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (lockObject) {
                lockObject.notify();
                System.out.println(Thread.currentThread().getName() + "\t-----通知");
            }
        }, "B").start();
    }
}
