package com.sbt.jscool.tasks._2044;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        Map<Character, String> map = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            map.put(st.nextToken().charAt(0), st.nextToken());
        }
        String code = reader.readLine();

        System.out.println(decoder(code, map));
    }

    private static String decoder(String str, Map<Character, String> map) {
        StringBuilder sb = new StringBuilder();
        while (!str.isEmpty()) {
            boolean flag = true;
            for (Map.Entry<Character, String> pair : map.entrySet()) {
                if (str.startsWith(pair.getValue())) {
                    sb.append(pair.getKey());
                    str = str.substring(pair.getValue().length());
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return sb.toString();
    }
}

