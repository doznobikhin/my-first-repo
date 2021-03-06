package com.sbt.jscool.lesson03._2057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 2057. Структуры данных. Множество
 */

public class Solution {
    private List<Integer> list;
    private boolean needToSort = false;
    private int index = -1;

    public Solution(int n) {
        this.list = new ArrayList<>(n);
    }

    public void add(Integer x) {
        if (1 <= x && x <= Math.pow(10, 9)) {
            this.list.add(x);
            this.needToSort = true;
            this.index++;
        }
    }

    public Integer removeMin() {
        if (needToSort) {
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            needToSort = false;
        }
        return list.remove(index--);
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (1 > n || n > Math.pow(10, 6)) {
            System.exit(1);
        }
        Solution sol = new Solution(n);

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
                sol.add(Integer.parseInt(array[1]));
            } else if (array.length == 1 && Integer.parseInt(array[0]) == 2) {
                System.out.println(sol.removeMin());
            }
        }
    }
}
