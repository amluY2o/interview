package com.jcj.interview.thread;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class ThreadPoolTest {

    private static final Integer CORE_POOL_SIZE = 2;
    private static final Integer MAXIMUM_POOL_SIZE = 5;
    private static final Long KEEP_ALIVE_TIME = 2L;


    public static void main(String[] args) {

//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        ExecutorService threadPool = Executors.newCachedThreadPool();

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("stats-pool-t%d").build();

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                namedThreadFactory,
                new ThreadPoolExecutor.DiscardPolicy()
        );
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "：办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }


}
