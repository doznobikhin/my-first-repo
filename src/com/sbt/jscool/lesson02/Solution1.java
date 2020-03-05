package com.sbt.jscool.lesson02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        Path fileName = Paths.get("D:\\school\\lesson02\\input.txt");
        List<String> list = Files.readAllLines(fileName);
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (String str : list) {
            String[] tmpArray = str.split(" ");
            for (String strInner : tmpArray) {
                set.add(strInner);
            }
        }

        /*for (String str : set) {
            //System.out.println(str);
        }*/
        System.out.println(set.size());

    }
}
