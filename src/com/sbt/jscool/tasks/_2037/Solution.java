package com.sbt.jscool.tasks._2037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int k = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();
        if (!(0 <= k && k <= 1000)) {
            System.out.println(s);
            System.exit(1);
        }
        for (String str : s.split(",")) {
            if (str.length() >= k) {
                sb.append(str);
                sb.append(",");
            }
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.toString().lastIndexOf(","));
        }
        System.out.println(sb.toString());

    }
}

