package com.sbt.jscool.lesson03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины
 * (компаратор сначала по длине слова, потом по тексту).
 */

public class Solution2 {
    public static void main(String[] args) {
        try {
            Path fileName = Paths.get(args[0]);
            List<String> list = Files.readAllLines(fileName);

            Set<String> set = new TreeSet<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length();
                }
            });
            for (String str : list) {
                set.addAll(Solution1.parseString(str));
            }

            System.out.println(set);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
