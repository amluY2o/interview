package com.jcj.interview.thread;

import java.util.concurrent.locks.ReentrantLock;

public class WindowTest {

    public static void main(String[] args) {
        Window w = new Window();
        new Thread(w, "窗口1").start();
        new Thread(w, "窗口2").start();
        new Thread(w, "窗口3").start();
    }
}

class Window implements Runnable {

    private int ticket = 100;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
//            synchronized(Window.class) {
            lock.lock();
            try {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "：售票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
//            }
            }finally {
                lock.unlock();
            }
        }
    }
}
