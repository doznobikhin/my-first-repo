package com.sbt.jscool.lesson02;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Solution6 {
    public static void main(String[] args) throws IOException {
        Path fileName = Paths.get("D:\\school\\lesson02\\input.txt");
        List<String> list = Files.readAllLines(fileName);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String strTmp = reader.readLine();
            if (strTmp.equals("exit")) {
                break;
            }
            try {
                int num = Integer.parseInt(strTmp);
                System.out.println(returnStr(num,list));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

        }

        /*System.out.println(returnStr(0,list));
        System.out.println(returnStr(2,list));
        System.out.println(returnStr(20,list));*/


    }

    private static String returnStr(int num,List<String> list) {
        if (!(0 <= num && num <= list.size())) {
            return "";
        } else {
            return list.get(num);
        }
    }

}
