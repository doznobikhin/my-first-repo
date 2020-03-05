package com.sbt.jscool.lesson02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        Path fileName = Paths.get("D:\\school\\lesson02\\input.txt");
        List<String> list = Files.readAllLines(fileName);
        List<String> list2 = new ArrayList<>();

        for (String str : list) {
            String[] tmpArray = str.split(" ");
            for (String strInner : tmpArray) {
                list2.add(strInner);
            }
        }

        Collections.sort(list2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });

        for (String str : list2) {
            System.out.println(str);
        }
    }
}
