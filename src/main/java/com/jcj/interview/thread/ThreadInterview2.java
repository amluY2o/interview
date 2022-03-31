package com.jcj.interview.thread;

import java.util.concurrent.TimeUnit;

public class ThreadInterview2 {

    public static void main(String[] args){

        Calculate c = new Calculate();

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 20; j++) {
                    c.add();
                    try {
                        TimeUnit.SECONDS.sleep(1L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            new Thread(() -> {
                for (int j = 0; j < 20; j++) {
                    c.sub();
                    try {
                        TimeUnit.SECONDS.sleep(1L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }


}

class Calculate{
    private int i = 100;

    public synchronized void add(){
        i++;
        System.out.println(Thread.currentThread().getName() + "：add " + i);
    }

    public synchronized void sub(){
        i--;
        System.out.println(Thread.currentThread().getName() + "：sub " + i);
    }
}