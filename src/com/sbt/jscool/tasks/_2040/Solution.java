package com.sbt.jscool.tasks._2040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        char indexLetter = chars[0];
        int index = -1;
        List<Integer> list = new ArrayList<>();
        while (index < str.lastIndexOf(indexLetter)) {
            index = str.indexOf(indexLetter, index + 1);
            list.add(index);
        }

        List<String> listStr = new ArrayList<>();
        for (Integer num : list) {
            listStr.add(str.substring(num) + str.substring(0, num));
        }
        listStr.sort(null);
        System.out.println(listStr.get(0));
    }
}