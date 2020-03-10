package com.sbt.jscool.lesson03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Задание 4: Выведите на экран все строки файла в обратном порядке.
 */

public class Solution4 {
    public static void main(String[] args) {
        try {
            Path fileName = Paths.get(args[0]);
            List<String> list = Files.readAllLines(fileName);

            StringBuilder sb;
            for (String str : list) {
                sb = new StringBuilder(str);
                System.out.println(sb.reverse());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
