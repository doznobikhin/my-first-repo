package com.sbt.jscool.lesson02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Solution4 {
    public static void main(String[] args) throws IOException {
        Path fileName = Paths.get("D:\\school\\lesson02\\input.txt");
        List<String> list = Files.readAllLines(fileName);

        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
            sb.append("\n");
        }
        sb.reverse();
        System.out.println(sb.toString());
    }
}
