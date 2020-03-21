package com.sbt.jscool.tasks._2036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(reader.readLine());
        }

        for (String s : list) {
            if (!s.matches("[a-z]*[eyuioa]{3,}[a-z]*")) {
                System.out.println(s);
            }
        }
    }
}