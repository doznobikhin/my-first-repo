package com.sbt.jscool.tasks._2053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (reader.ready()) {
            sb.append(reader.readLine());
            sb.append(" ");
        }
        String str = sb.toString().toLowerCase().replaceAll("\\s+", " ").trim();

        Map<String, Integer> map = new HashMap<>();
        int arrayLen = str.split(" ").length;
        sb = new StringBuilder(arrayLen);
        for (String s : str.split(" ")) {
            if (map.containsKey(s)) {
                sb.append(map.get(s));
            } else {
                map.put(s, map.size() + 1);
                sb.append(map.size());
            }
            sb.append(" ");
        }
        if (sb.length() > 0) {
            System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
        }
    }
}
