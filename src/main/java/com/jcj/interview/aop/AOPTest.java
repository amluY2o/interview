package com.jcj.interview.aop;

public class AOPTest {
    public static void main(String[] args) {

        ICalculator proxy = CalculatorProxy.getProxy(new MyCalculatorImpl());

        proxy.add(1,1);
        proxy.sub(1,1);
        proxy.mul(10,10);
        proxy.div(100,10);
    }
}
