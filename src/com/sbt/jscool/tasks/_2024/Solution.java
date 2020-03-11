package com.sbt.jscool.tasks._2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int[] array = new int[n];
        for (int i = 0; st.hasMoreTokens() && i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int number = 0;
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                number++;
            }
        }
        System.out.println(number);
    }
}
