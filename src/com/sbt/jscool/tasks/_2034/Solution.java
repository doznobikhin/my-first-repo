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
        //1 ≤ n ≤ 10000
        if (n < 1 || n > 10001) {
            System.exit(1);
        }
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int[] array = new int[n];
        for (int i = 0; st.hasMoreTokens() && i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        //System.out.println(Arrays.toString(array));

        cycle:
        for (int i = array.length; i >= 1; i--) {
            for (int j = 0; j <= (array.length - i); j++) {
                int[] tmpArray = Arrays.copyOfRange(array, j, j + i);
                if (isCons(tmpArray)) {
                    System.out.println((j + 1) + " " + (i + j));
                    break cycle;
                }
                //System.out.println(Arrays.toString(tmpArray) + " " + isCons(tmpArray));
            }
        }

    }

    private static boolean isCons(int[] array) {
        /*int[] copiedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(copiedArray);
        return copiedArray[copiedArray.length - 1] - copiedArray[0] <= 1;
        */
        Arrays.sort(array);
        return array[array.length - 1] - array[0] <= 1;
    }
}

