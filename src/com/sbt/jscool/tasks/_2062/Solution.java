package com.sbt.jscool.tasks._2062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Set<Point> setInit = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            setInit.add(new Point(x, y));
        }

        Set<Point> setWork = new TreeSet<>(setInit);
        for (int i = 0; i < k; i++) {
            Set<Point> setTmp = new TreeSet<>();
            for (Point point : setWork) {
                setTmp.addAll(point.getStarSet());
            }
            setInit.addAll(setTmp);
            setWork = setTmp;
        }

        for (Point point : setInit) {
            System.out.println(point);
        }
    }

    public static class Point implements Comparable<Point> {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Set<Point> getStarSet() {
            Set<Point> tmpSet = new HashSet<>();
            tmpSet.add(new Point(x, y + 1));
            tmpSet.add(new Point(x, y - 1));
            tmpSet.add(new Point(x + 1, y));
            tmpSet.add(new Point(x - 1, y));
            return tmpSet;
        }

        @Override
        public int compareTo(Point o) {
            return this.x == o.x ? this.y - o.y : this.x - o.x;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
