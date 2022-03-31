package com.jcj.interview.thread;


import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;

class Account{
    private BigDecimal balance;
    private ReentrantLock reentrantLock = new ReentrantLock();

    public Account(BigDecimal balance){
        this.balance = balance;
    }

    public void add(BigDecimal money){
        if(money != null && money.compareTo(new BigDecimal("0")) == 1){
            try {
                reentrantLock.lock();
                balance = balance.add(money);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "：存款，余额为：" + balance.toString());
            }finally {
                reentrantLock.unlock();
            }
        }
    }
}

class Customer implements Runnable{

    private Account account;

    public Customer(Account account){
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.add(new BigDecimal("1000"));
        }
    }
}


public class AccountTest {

    public static void main(String[] args){

        Account account = new Account(new BigDecimal("0"));


        Customer customer = new Customer(account);

        new Thread(customer,"顾客1").start();
        new Thread(customer,"顾客2").start();
        new Thread(customer,"顾客3").start();

    }
}
