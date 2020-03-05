package com.sbt.jscool.lesson02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {
    public static void main(String[] args) throws IOException {
        Path fileName = Paths.get("D:\\school\\lesson02\\input.txt");
        List<String> list = Files.readAllLines(fileName);
        Map<String, Integer> map = new HashMap<>();

        for (String str : list) {
            String[] tmpArray = str.split(" ");
            for (String strInner : tmpArray) {
                if (map.containsKey(strInner)) {
                    int value = map.get(strInner);
                    map.replace(strInner, value + 1);
                } else {
                    map.put(strInner, 1);
                }
            }
        }
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

    }
}
