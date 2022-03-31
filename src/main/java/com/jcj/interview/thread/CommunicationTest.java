package com.jcj.interview.thread;

public class CommunicationTest {

    public static void main(String[] args) {
        Number number = new Number();

        new Thread(number).start();
        new Thread(number).start();
    }
}

class Number implements Runnable {

    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + "：" + number);
                    number++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
