package com.jcj.interview.thread;

public class ThreadMethodTest {

    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("线程1");
        h1.start();

        Thread.currentThread().setName("主线程");

        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }

//            if(i == 20){
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}

class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(this.getName() + ",priority" + this.getPriority() + " : " + i);
            }

//            if(i == 50){
//                try {
//                    sleep(5 *1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
    public HelloThread(String name){
        super(name);
    }

}
