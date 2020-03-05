package com.sbt.jscool.tasks._2038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        if (str.length() > 10000) {
            System.exit(1);
        }

        StringBuilder sb = new StringBuilder();

        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if ((array[i] >= 65 && array[i] <= 90) || (array[i] >= 97 && array[i] <= 122)) {
                sb.append(array[i]);
            } else {
                sb.append(",");
            }
        }

        int max = 0;
        for (String s : sb.toString().split(",")) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        System.out.println(max);
    }
}
