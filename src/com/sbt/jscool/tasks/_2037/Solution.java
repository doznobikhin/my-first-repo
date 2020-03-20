package com.sbt.jscool.tasks._2037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int len = Integer.parseInt(reader.readLine());
        if (str.length() > 1000 || (len < 0 || len > 1001) || !str.matches("[a-z,]+")) {
            System.exit(1);
        }
        
        System.out.println(processString(str, len));
    }

    private static String processString(String str, int len) {
        if (len == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : str.split(",")) {
            if (s.length() >= len) {
                sb.append(",");
                sb.append(s);
            }
        }
        if (sb.length() > 0) {
            return sb.deleteCharAt(0).toString();
        }
        return "";
    }
}
