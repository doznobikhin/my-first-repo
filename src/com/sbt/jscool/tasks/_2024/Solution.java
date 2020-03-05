package com.sbt.jscool.tasks._2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
        Arrays.sort(array);

        System.out.println(Arrays.toString(array));

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length - (array.length % 2); i++) {
            if (map.containsKey(array[i])) {
                int value = map.get(array[i]);
                map.replace(array[i], value + 1);
            } else {
                map.put(array[i], 1);
            }
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            sum += pair.getValue() % 2;
        }
        System.out.println(sum / 2);
    }

}
