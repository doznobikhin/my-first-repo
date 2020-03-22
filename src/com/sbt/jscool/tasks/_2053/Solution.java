package com.sbt.jscool.tasks._2053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (reader.ready()) {
            sb.append(reader.readLine());
            sb.append(" ");
        }
        String str = sb.toString().toLowerCase().replaceAll("\\s+", " ").trim();

        //Map<Integer, String> map = new TreeMap<>();
        int arrayLen = str.split(" ").length;
        List<String> list = new ArrayList<>(arrayLen);

        sb = new StringBuilder(arrayLen);
        for (String s : str.split(" ")) {
            if (list.contains(s)) {
                sb.append(list.indexOf(s) + 1);
            } else {
                list.add(s);
                sb.append(list.size());
            }
            sb.append(" ");
        }
        if (sb.length() > 0) {
            System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
        }

    }
}
