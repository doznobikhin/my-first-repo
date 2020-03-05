package com.sbt.jscool.tasks._2034;

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

        cycle:
        for (int i = array.length; i >= 2; i--) {
            for (int j = 0; j <= (array.length - i); j++) {
                int[] tmpArray = Arrays.copyOfRange(array, j, j + i);
                if (isCons(tmpArray)) {
                    System.out.println((j + 1) + " " + (i + j));
                    break cycle;
                }
            }
        }

    }

    private static boolean isCons(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        return max - min <= 1;
    }
}

