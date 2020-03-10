package com.sbt.jscool.lesson03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
 */

public class Solution6 {
    public static void main(String[] args) throws IOException {
        List<String> list = null;
        try {
            Path fileName = Paths.get(args[0]);
            list = Files.readAllLines(fileName);
        } catch (Exception e) {
            System.exit(1);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String strTmp = reader.readLine();
            if (strTmp.equals("exit")) {
                break;
            }
            try {
                int num = Integer.parseInt(strTmp);
                System.out.println((0 <= num && num < list.size()) ? list.get(num) : "max line number = " + (list.size() - 1));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
