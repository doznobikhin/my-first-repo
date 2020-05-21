package com.sbt.jscool.lection11;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/*
 * Дан файл содержащий несколько случайных натуральных чисел от 1 до 50
 * Необходимо написать многопоточное приложение которое параллельно рассчитает и
 * выведет в консоль факториал для каждого числа из файла.
 *
 * */


public class Solution2 {
    private List<Integer> list;

    private void fillList(String fileName) throws IOException {
        Path pathName = Paths.get(fileName);
        list = Files.readAllLines(pathName)
                .stream()
                .map(line -> line.split(" "))
                .flatMap(Arrays::stream)
                .filter(a -> !a.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
    }

    private BigInteger factorial(int number) {
        BigInteger result = BigInteger.ONE;
        for (int k = 1; k <= number; ++k) {
            result = result.multiply(BigInteger.valueOf(k));
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Solution2 sol = new Solution2();
        sol.fillList("D:\\school\\lesson11_threads\\task11.txt");

        Executor executor = Executors.newFixedThreadPool(4);

//        sol.list.sort(Comparator.reverseOrder());
//        System.out.println(sol.list);

        for (int i = 0; i < sol.list.size(); i++) {
            final int num = sol.list.get(i);
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " " + num + "! = " + sol.factorial(num));
            });
        }

        ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;
        pool.shutdown();
    }
}

