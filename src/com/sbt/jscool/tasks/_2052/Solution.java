package com.sbt.jscool.tasks._2052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; st.hasMoreTokens() && i < n; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(reader.readLine());
        List<Integer> operations = new ArrayList<>();
        for (int i = 0; st.hasMoreTokens() && i < k; i++) {
            operations.add(Integer.parseInt(st.nextToken()));
        }

        for (Integer delim : operations) {
            List<Integer> listTmp = new ArrayList<>(numbers.size());
            for (int i = 0; i < numbers.size(); i++) {
                if ((i + 1) % delim != 0) {
                    listTmp.add(numbers.get(i));
                }
            }
            numbers = listTmp;
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]{1}", ""));


        /* 14 тестов из 20
        for (Integer delim : operations) {
            numbers.removeIf(element -> ((numbers.indexOf(element) + 1) % delim == 0));
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]{1}", ""));*/
    }
}