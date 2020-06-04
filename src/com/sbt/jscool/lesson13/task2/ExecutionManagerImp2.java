package com.sbt.jscool.lesson13.task2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
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
    private CountDownLatch startCallback;

    private volatile AtomicInteger failedCounter = new AtomicInteger(0);
    private volatile AtomicInteger interruptedCounter = new AtomicInteger(0);
    private volatile AtomicInteger completedCounter = new AtomicInteger(0);
    private volatile boolean cancel = false;


    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
        if (callback == null || tasks == null || tasks.length == 0) {
            throw new IllegalArgumentException();
        }

        startCallback = new CountDownLatch(tasks.length);
        ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        futures = Arrays.stream(tasks).
                map(task -> (Runnable) () -> {
                    try {
                        if (cancel) {
                            interruptedCounter.getAndIncrement();
                        } else {
                            task.run();
                            completedCounter.getAndIncrement();
                        }
                    } catch (Exception e) {
                        failedCounter.getAndIncrement();
                    } finally {
                        startCallback.countDown();
                    }
                }).
                map(service::submit).
                collect(Collectors.toList());


        service.submit(() -> {
            try {
                startCallback.await();
            } catch (InterruptedException e) {
//                e.printStackTrace();
            } finally {
                callback.run();
            }
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

}
