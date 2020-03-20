package com.sbt.jscool.tasks._2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String template = reader.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= str.length() - template.length(); i++) {
            String strTmp = str.substring(i, i + template.length());
            if (strTmp.matches(regExString(template))) {
                sb.append(i + 1);
                sb.append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }

    private static String regExString(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        int qMarkCount = 0;
        for (char letter : chars) {
            if (Character.toString(letter).equals("?")) {
                qMarkCount++;
            } else if (qMarkCount > 0) {
                sb.append("[a-z]{");
                sb.append(qMarkCount);
                sb.append("}");
                qMarkCount = 0;
                sb.append(letter);
            } else {
                sb.append(letter);
            }
        }
        if (qMarkCount > 0) {
            sb.append("[a-z]{");
            sb.append(qMarkCount);
            sb.append("}");
        }
        return sb.toString();
    }
}