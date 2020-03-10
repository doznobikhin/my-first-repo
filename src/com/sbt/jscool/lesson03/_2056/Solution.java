package com.sbt.jscool.lesson03._2056;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        //String input = "a aa aaa aaaa\na AA aaa bbbb";
        String input = "Sebastian Vettel is a German Formula One racing driver currently driving for Red Bull Racing";
        /*System.out.println(input);
        System.out.println();*/
        List<String> list = parseString(input.toLowerCase());
        /*for (String str : list) {
            System.out.println(str);
        }*/

        Set<String> set = new TreeSet<>(list);
        Map<String,Integer> map = new TreeMap<>();
        int max = 1;
        for (String str : set) {
            int frequency = Collections.frequency(list,str);
            //System.out.println(str + " " + frequency);
            map.put(str,frequency);
            if (frequency > max) {
                max = frequency;
            }
        }
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            if (max == pair.getValue()) {
                System.out.printf("%s%n",pair.getKey());
            }
        }
    }

    static List<String> parseString(String s) {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("[a-zA-Zа-яА-Я]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            list.add(s.substring(matcher.start(), matcher.end()));
        }
        return list;
    }
}
