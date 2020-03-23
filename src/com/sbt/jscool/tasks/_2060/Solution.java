package com.sbt.jscool.tasks._2060;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<String> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(reader.readLine());
        }

        Map<String, List<Integer>> map = new TreeMap<>();
        StringTokenizer st;
        for (String str : list) {
            st = new StringTokenizer(str);
            String name = st.nextToken();
            Integer mark = Integer.parseInt(st.nextToken());
            if (map.containsKey(name)) {
                List<Integer> marks = map.get(name);
                marks.add(mark);
            } else {
                List<Integer> marks = new ArrayList<>();
                marks.add(mark);
                map.put(name, marks);
            }
        }

        for (Map.Entry<String, List<Integer>> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + averageMark(pair.getValue()));
        }

    }

    private static int averageMark(List<Integer> marks) {
        int sum = 0;
        for (Integer mark : marks) {
            sum += mark;
        }
        return sum / marks.size();
    }
}
