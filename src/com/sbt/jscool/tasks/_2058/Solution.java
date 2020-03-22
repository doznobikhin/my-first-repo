package com.sbt.jscool.tasks._2058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        /*String woSpaces = str.replaceAll("\\s?", "");
        System.out.println(result(str.length()) - (str.length()-woSpaces.length()));*/
        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length() + 1; j++) {
                //System.out.println(str.substring(i, j));
                set.add(str.substring(i, j));
            }
        }
        //System.out.println(set + " " + set.size());
        System.out.println(set.size());
    }

    private static int result(int len) {
        if (len == 1) {
            return 0;
        } else {
            return len + result(len - 1);
        }
    }
}
