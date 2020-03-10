package com.sbt.jscool.lesson03._2057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private List<Integer> list = new ArrayList<>();

    public void add(Integer x) {
        if (1 <= x && x <= Math.pow(10, 9)) {
            this.list.add(x);
        }
    }

    public Integer removeMin() {
        if (!list.isEmpty()) {
            Collections.sort(list);
            return list.remove(0);
        }
        throw new IndexOutOfBoundsException();
    }

    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (1 > n || n > Math.pow(10, 6)) {
            System.exit(1);
        }

        //заполняем список входных данных
        List<String> inputList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String strTmp = reader.readLine();
            if (strTmp.split(" ").length <= 2) {
                inputList.add(strTmp);
            }
        }

        for (String str : inputList) {
            String[] array = str.split(" ");
            if (array.length == 2 && Integer.parseInt(array[0]) == 1) {
                if (1<=Integer.parseInt(array[1]) && Integer.parseInt(array[1])<=Math.pow(10,9)) {
                    sol.add(Integer.parseInt(array[1]));
                }

            } else if (array.length == 1 && Integer.parseInt(array[0]) == 2) {
                System.out.println(sol.removeMin());
            }
        }
    }
}
