package com.sbt.jscool.tasks._2045;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        char[] array = str.toCharArray();

        int[] symbols = {32, 33, 44, 46, 63};

        StringBuilder sb = new StringBuilder();
        StringBuilder sbMarks = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (Arrays.binarySearch(symbols, array[i]) > -1) {
                sbMarks.append(array[i]);
            } else {
                if (sbMarks.length() > 0) {
                    sb.append(processMarks(sbMarks));
                }
                sb.append(array[i]);
            }
        }
        System.out.println(sb.toString());
    }

    private static String processMarks(StringBuilder sbMarks) {
        String str = sbMarks.toString().replace(" ", "");
        sbMarks.delete(0, sbMarks.length());

        StringBuilder sb = new StringBuilder();
        if (str.isEmpty()) {
            sb.append(' ');
        } else {
            for (Character character : str.toCharArray()) {
                sb.append(character);
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
