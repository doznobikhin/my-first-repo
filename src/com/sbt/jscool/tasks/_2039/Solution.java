package com.sbt.jscool.tasks._2039;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        str = str.replaceAll("[^a-zA-Z]+", " ").trim();
        System.out.println(str.split(" ").length);
    }
}
