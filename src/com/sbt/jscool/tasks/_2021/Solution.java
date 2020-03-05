package com.sbt.jscool.tasks._2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        changeArray(array);
        changeArray(array);
        System.out.println(Arrays.toString(array)
                .replace("[","")
                .replace("]","")
                .replace(",",""));
    }

    private static int getMaxValue(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static void changeArray(int[] array) {
        int max = getMaxValue(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == max) {
                array[i]/=2;
            }
        }
    }
}

