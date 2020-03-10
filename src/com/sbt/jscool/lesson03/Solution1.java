package com.sbt.jscool.lesson03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Задание 1: Подсчитайте количество различных слов в файле.
 */

public class Solution1 {
    public static void main(String[] args) {
        try {
            Path fileName = Paths.get(args[0]);
            List<String> list = Files.readAllLines(fileName);

            Set<String> set = new HashSet<>();
            for (String str : list) {
                set.addAll(parseString(str));
            }

            System.out.println(set.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static List<String> parseString(String s) {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("[a-zA-Zа-яА-Я]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            list.add(s.substring(matcher.start(), matcher.end()));
        }
        return list;
    }
}
