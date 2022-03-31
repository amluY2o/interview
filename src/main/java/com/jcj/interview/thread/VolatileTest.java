package com.jcj.interview.thread;

import java.util.concurrent.TimeUnit;

public class VolatileTest {

    public static void main(String[] args){
        MyData data = new MyData();

    }

    /**
     * volatile 可见性测试
     */
    private static void seeOkByVolatile() {
        MyData data = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":start");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.change();
            System.out.println(Thread.currentThread().getName() + ":number updated " + data.number);
        }).start();


        while(data.number == 0){

        }

        System.out.println(Thread.currentThread().getName() + " : over,number = " +data.number);
    }
}


class MyData{
    volatile int number = 0;
    public void change(){
        this.number = 100;
    }
}
