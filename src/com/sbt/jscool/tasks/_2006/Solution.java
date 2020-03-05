package com.sbt.jscool.tasks._2006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        int inch = 3;
        int feet = 12 * inch;

        int quotientFt = number / feet;
        int remainderFt = number % feet;
        int remainderInch = remainderFt % inch;
        int quotientInch = remainderFt /inch + (int) Math.round(1.0* remainderInch/inch);

        System.out.println(quotientFt + " " + quotientInch);
    }
}

