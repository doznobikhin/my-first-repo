package com.sbt.jscool.tasks._2007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        if (1 <= number && number <= Math.pow(10, 9)) {
            String strNumber = Integer.toBinaryString(number);
            int length = strNumber.length();
            int index = strNumber.lastIndexOf("1");
            System.out.println(length - 1 - index);
        }
    }
}

