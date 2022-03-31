package com.jcj.interview.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {

    static AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock(){
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() +" 进入");
        while(!atomicReference.compareAndSet(null, currentThread)){}
    }

    public void unlock(){
        Thread currentThread = Thread.currentThread();
        atomicReference.compareAndSet(currentThread, null);
        System.out.println(currentThread.getName() +" 解除");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.lock();
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            spinLockDemo.unlock();
        },"t1").start();

        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(() -> {
            spinLockDemo.lock();
            spinLockDemo.unlock();
        },"t2").start();
    }
}
