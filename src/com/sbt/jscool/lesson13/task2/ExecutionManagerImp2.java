package com.sbt.jscool.lesson13.task2;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/*
 * Ваша задача реализовать интерфейс ExecutionManager
 * Метод execute принимает массив тасков, это задания которые ExecutionManager должен выполнять параллельно
 * (в вашей реализации пусть будет в своем пуле потоков). После завершения всех тасков должен выполниться
 * callback (ровно 1 раз).
 * Метод execute – это неблокирующий метод, который сразу возвращает объект Context.
 *
 * */


public class ExecutionManagerImp2 implements ExecutionManager {
    private List<Future<?>> futures;

    private volatile AtomicInteger failedCounter = new AtomicInteger(0);
    private volatile AtomicInteger interruptedCounter = new AtomicInteger(0);
    private volatile AtomicInteger completedCounter = new AtomicInteger(0);
    private volatile boolean cancel = false;


    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
        if (callback == null || tasks == null || tasks.length == 0) {
            throw new IllegalArgumentException();
        }


        ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        futures = Arrays.stream(tasks).
                map(task -> (Runnable) () -> {
                    if (cancel) {
                        interruptedCounter.getAndIncrement();
                    } else {
                        try {
                            task.run();
                            completedCounter.getAndIncrement();
                        } catch (Exception e) {
                            failedCounter.getAndIncrement();
                        }
                    }
                }).
                map(service::submit).
                collect(Collectors.toList());


        service.submit(() -> {
            while ((interruptedCounter.get() +
                    completedCounter.get() +
                    failedCounter.get()) < futures.size()) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            callback.run();
        });
        service.shutdown();

        return new ContextImp();
    }


    private class ContextImp implements Context {

        @Override
        public int getCompletedTaskCount() {
            return completedCounter.get();
        }

        @Override
        public int getFailedTaskCount() {
            return failedCounter.get();
        }

        @Override
        public int getInterruptedTaskCount() {
            return interruptedCounter.get();
        }

        @Override
        public void interrupt() {
            cancel = true;
        }

        @Override
        public boolean isFinished() {
            return (interruptedCounter.get() + completedCounter.get() + failedCounter.get()) == futures.size();
        }
    }

    private static BigInteger factorial(int number) {
        if (number < 0) {
            throw new RuntimeException("number < 0 ");
        }
        BigInteger result = BigInteger.ONE;
        for (int j = 2; j <= number; j++) {
            result = result.multiply(BigInteger.valueOf(j));
        }
        return result;
    }


    public static void main(String[] args) {
        Runnable[] tasks = new Runnable[10];
        int[] numbers = new int[]{10, 11, 12, -13, 14, 15, 16, -17, 18, -19};
        for (int i = 0; i < tasks.length; i++) {
            int number = numbers[i] * 10 + numbers[i] % 10;
            tasks[i] = () -> {
                if (number % 2 == 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.err.println(Thread.currentThread().getName() + " " + number + ", " + factorial(number));
            };
        }
        Runnable callback = () -> System.err.println("well done");
        ExecutionManager executionManager = new ExecutionManagerImp2();
        Context context = executionManager.execute(callback, tasks);

        while (!context.isFinished()) {
            System.err.println("*************");
            System.err.println(context.getCompletedTaskCount());
            System.err.println(context.getFailedTaskCount());
            System.err.println(context.getInterruptedTaskCount());
            try {
                Thread.sleep(500 * 4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            context.interrupt();
        }
        System.err.println("*************");
        System.err.println(context.getCompletedTaskCount());
        System.err.println(context.getFailedTaskCount());
        System.err.println(context.getInterruptedTaskCount());

    }
}
