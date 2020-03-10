package com.sbt.jscool.lesson03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
 */

public class Solution3 {
    public static void main(String[] args) {
        try {
            Path fileName = Paths.get(args[0]);
            List<String> list = Files.readAllLines(fileName);

            List<String> listOfWords = new ArrayList<>();
            for (String str : list) {
                listOfWords.addAll(Solution1.parseString(str));
            }

            Set<String> set = new TreeSet<>(listOfWords);
            for (String str : set) {
                System.out.printf("%s %d%n", str, Collections.frequency(listOfWords, str));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
