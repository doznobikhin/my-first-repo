package com.sbt.jscool.tasks._2035;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    private static List<Integer> divisorList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int[] array = new int[n];
        for (int i = 0; st.hasMoreTokens() && i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        fillDivisorList(array.length);

        int period = array.length;

        for (int i = 0; i < divisorList.size(); i++) {
            if (divisorList.get(i) == array.length) {
                break;
            }
            int[] tmpArray = Arrays.copyOf(array, divisorList.get(i));
            //System.out.println(Arrays.toString(tmpArray));
            int[] compArray = new int[array.length];
            for (int j = 0; j < compArray.length; j++) {
                int k = j % divisorList.get(i);
                //System.out.println(j + " " + k);
                compArray[j] = tmpArray[k];
            }
            //System.out.println(Arrays.toString(compArray));
            if (Arrays.equals(array, compArray)) {
                period = divisorList.get(i);
                break;
            }
        }
        System.out.println(period);
    }

    private static void fillDivisorList(int maxNumber) {
        divisorList.add(1);
        for (int i = 2; i < maxNumber - 1; i++) {
            if (maxNumber % i == 0) {
                divisorList.add(i);
            }
        }
        divisorList.add(maxNumber);
    }
}
/*System.out.println(Arrays.toString(array));
        int[] array2 = Arrays.copyOf(array,array.length);
        System.out.println(Arrays.toString(array));

        System.out.println(Arrays.equals(array,array2));*/
