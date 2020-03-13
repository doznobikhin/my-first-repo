package com.sbt.jscool.tasks._2034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    private int[] array;
    private List<Point> list;

    public Solution(int[] array) {
        this.array = array;
        this.list = new ArrayList<>();
    }

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


        Solution sol = new Solution(array);
        sol.findConsArray(0, sol.array.length - 1);
        Collections.sort(sol.list);

        //System.out.println(sol.list);
        System.out.println(sol.list.get(0));


        //     2 3 2 1 2 3 4 2
        //           1     4        3
        //     2 3 2 1 2 3            2 3 4 2
        //       3   1     2          2   4    2
        //     2 3 2   2 1 2 3        2 3    3 4 2
        //     2 3       1   3        2 3      4 2

    }

    public void findConsArray(int begin, int end) {
        for (Point pt : list) {
            if (pt.getLenght() > end - begin) {
                return;
            }
        }

        int max = array[begin];
        int min = array[begin];
        int indxMax = begin;
        int indxMin = begin;
        for (int i = begin; i <= end; i++) {
            if (array[i] > max) {
                max = array[i];
                indxMax = i;
            } else if (array[i] < min) {
                min = array[i];
                indxMin = i;
            }
        }
        if (max - min <= 1) {
            list.add(new Point(begin, end));
            return;
        }

        int start = indxMax;
        int finish = indxMin;
        if (indxMax > indxMin) {
            start = indxMin;
            finish = indxMax;
        }
        findConsArray(begin, finish - 1);
        findConsArray(start + 1, end);
    }
    // begin  start    finish      end

    public static class Point implements Comparable<Point> {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x + 1;
            this.y = y + 1;
        }

        public int getLenght() {
            return y - x;
        }

        @Override
        public int compareTo(Point o) {
            return this.y - this.x == o.y - o.x ? this.x - o.x : (o.y - o.x) - (this.y - this.x);
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}

