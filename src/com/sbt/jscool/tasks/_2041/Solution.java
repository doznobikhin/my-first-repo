package com.sbt.jscool.tasks._2041;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        System.out.println(isConcatPalindrome(str));
    }

    private static String isConcatPalindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
            String strTmp1 = str.substring(0, i);
            String strTmp2 = str.substring(i);
            if (isPalindrome(strTmp1) && isPalindrome(strTmp2)) {
                return "YES";
            }
        }
        return "NO";
    }

    private static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }
        //StringBuilder sb1 = new StringBuilder(str.substring(0, str.length() / 2));
        String str1 = str.substring(0, str.length() / 2);
        StringBuilder sb2 = new StringBuilder(str.substring((str.length() + 1) / 2));
        return str1.equals(sb2.reverse().toString());
    }
}