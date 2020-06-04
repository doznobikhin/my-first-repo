package com.sbt.jscool.lesson13.task2;

import java.math.BigInteger;

public class ExecutionManagerTest {

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
