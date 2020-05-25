package com.sbt.jscool.lection11;

import java.util.concurrent.*;

/*
 * FixedThreadPool - Количество потоков задается в конструкторе и не меняется.
 * */
public class FixedThreadPool implements ThreadPool {
    private final ThreadPoolExecutor pool;
    private final int MIN_THREADS_NUMBER = 1;
    private final int MAX_THREADS_NUMBER = 8;

    public FixedThreadPool(int number) {
        if (number < MIN_THREADS_NUMBER) {
            throw new IllegalArgumentException("number should be >= " + MIN_THREADS_NUMBER);
        } else if (number > MAX_THREADS_NUMBER) {
            throw new IllegalArgumentException("number should be <= " + MAX_THREADS_NUMBER);
        }

//        pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(number);
        pool = new ThreadPoolExecutor(number,number,1L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());
    }

    @Override
    public void start() {
        pool.prestartAllCoreThreads();
    }

    @Override
    public void execute(Runnable runnable) {
//        queue.add(runnable);
        pool.execute(runnable);
    }

    public static void main(String[] args) {
        FixedThreadPool ftp = new FixedThreadPool(8);
        System.out.println(ftp.pool.getCorePoolSize());
        System.out.println(ftp.pool.getActiveCount());
        ftp.start();
        System.out.println(ftp.pool.getActiveCount());

        Runnable r1 = () -> {
            System.out.printf("%s %s%n", Thread.currentThread().getName(), "runnable");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 50; i++) {
            ftp.execute(r1);
        }
//        ftp.pool.setKeepAliveTime(1L, TimeUnit.MILLISECONDS);
        ftp.pool.shutdown();
    }
}
