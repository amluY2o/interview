package com.jcj.interview.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 编写程序实现,子线程循环10次,接着主线程循环20次,
 * 接着再子线程循环10次,主线程循环20次,
 * 如此反复,循环50次.
 */
public class ThreadInterview1 {
    public static void main(String[] args) {

        Function function = new Function();
        Function2 function2 = new Function2();

        new Thread(() -> {
            for (int i = 1; i <= 50; i++) {
                //function.subThread();
                function2.sub();
            }
        }).start();

        for (int i = 1; i <= 50; i++) {
            //function.mainThread();
            function2.main();
        }

    }

}

/**
 * synchronized 关键字来实现
 */
class Function{
    boolean flag = false;

    public synchronized void subThread(){
        while(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + "：" + i);
        }

        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = true;
        this.notify();
    }

    public synchronized void mainThread(){
        while(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 1; i <= 20; i++) {
            System.out.println(Thread.currentThread().getName() + "：" + i);
        }

        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = false;
        this.notify();
    }
}

class Function2{
    private boolean flag = false;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void sub(){
        lock.lock();
        try {
            while(flag){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }

            flag = true;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void main(){
        lock.lock();
        try {
            while(!flag){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 1; i <= 20; i++) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
            flag = false;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}


