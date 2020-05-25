package com.sbt.jscool.lection11;

import java.util.concurrent.*;


/*
 * 2) ScalableThreadPool в конструкторе задается минимальное и максимальное(int min, int max) число потоков,
 * количество запущенных потоков может быть увеличено от минимального к максимальному, если при добавлении нового
 * задания в очередь нет свободного потока для исполнения этого задания. При отсутствии задания в очереди, количество
 * потоков опять должно быть уменьшено до значения min*
 * */


public class ScalableThreadPool implements ThreadPool {
    private final ThreadPoolExecutor pool;
    private final int MIN_THREADS_NUMBER = 1;
    private final int MAX_THREADS_NUMBER = 8;

    public ScalableThreadPool(int min, int max) {
        if (min < MIN_THREADS_NUMBER || min > max) {
            throw new IllegalArgumentException("min should be >= " + MIN_THREADS_NUMBER + " and <= max");
        } else if (max > MAX_THREADS_NUMBER) {
            throw new IllegalArgumentException("max should be <= " + MAX_THREADS_NUMBER);
        }

        // new ArrayBlockingQueue(10) RejectedExecutionException
        pool = new ThreadPoolExecutor(min,max,1L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());
    }

    @Override
    public void start() {
        pool.prestartAllCoreThreads();
    }

    @Override
    public void execute(Runnable runnable) {
        pool.execute(runnable);
    }

    public static void main(String[] args) {
        ScalableThreadPool stp = new ScalableThreadPool(3,8);
        System.out.println("the core number of threads " + stp.pool.getCorePoolSize());
        System.out.println("the maximum allowed number of threads " + stp.pool.getMaximumPoolSize());
        System.out.println(stp.pool.getActiveCount() + " * the current number of threads in the pool " + stp.pool.getPoolSize());
        stp.start();
        System.out.println(stp.pool.getActiveCount() + " * the current number of threads in the pool " + stp.pool.getPoolSize());

        Runnable r1 = () -> {
            System.out.printf("%s %s%n", Thread.currentThread().getName(), "runnable");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 28; i++) {
            stp.execute(r1);
        }

        System.out.println(stp.pool.getActiveCount() + " * the current number of threads in the pool " + stp.pool.getPoolSize());
        stp.pool.shutdown();

    }
}
