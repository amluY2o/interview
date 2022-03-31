package com.jcj.interview.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HeapOOM {
    byte[] b=  new byte[1024 * 100];

    public static void main(String[] args) throws InterruptedException {
        List<HeapOOM> list = new ArrayList<>();
        while (true) {
            list.add(new HeapOOM());
            TimeUnit.MILLISECONDS.sleep(10);
        }
    }
}
