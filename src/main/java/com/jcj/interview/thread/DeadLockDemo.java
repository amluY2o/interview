package com.jcj.interview.thread;


import lombok.AllArgsConstructor;

/**
 * 死锁是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待的现象
 * jps -l
 * jstack 进程号
 */
@AllArgsConstructor
class DeadLock implements Runnable{
    private String lockA;
    private String lockB;

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName() + "\t 自己持有" + lockA + ", 尝试获得" + lockB);
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + "\t 自己持有" + lockB + ", 尝试获得" + lockA);
            }
        }
    }
}
public class DeadLockDemo {
    public static void main(String[] args) {
        new Thread(new DeadLock("lockA", "lockB"), "A").start();
        new Thread(new DeadLock("lockB", "lockA"), "B").start();
    }
}
