package com.sbt.jscool.tasks._2054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(reader.readLine());
        }

        Map<Integer, Set<Integer>> map = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            StringTokenizer st = new StringTokenizer(list.get(i));
            int numTmp = Integer.parseInt(st.nextToken());
            for (int j = 0; st.hasMoreTokens() && j < numTmp; j++) {
                Integer intTmp = Integer.parseInt(st.nextToken());
                appendToMap(map, intTmp, i + 1);
            }
        }

        for (Map.Entry<Integer, Set<Integer>> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue().toString().replaceAll("[\\[\\],]+", ""));
        }
    }

    private static void appendToMap(Map<Integer, Set<Integer>> map, Integer number, int stringNumber) {
        if (map.containsKey(number)) {
            map.get(number).add(stringNumber);
        } else {
            Set<Integer> setTmp = new TreeSet<>();
            setTmp.add(stringNumber);
            map.put(number, setTmp);
        }
    }
}
