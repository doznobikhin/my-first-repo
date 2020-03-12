package com.sbt.jscool.lesson03._2056;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        input = input.toLowerCase().replaceAll("\\s{1,}"," ").trim();*/

        Path inputFile = Paths.get("input.txt");
        List<String> list = Files.readAllLines(inputFile);
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
            sb.append("\n");
        }

        String input = sb.toString().toLowerCase().replaceAll("\\s{1,}", " ").trim();

        List<String> wordsList = new ArrayList<>(Arrays.asList(input.split(" ")));
        //wordsList.addAll(Arrays.asList(input.split(" ")));
        Set<String> set = new TreeSet<>(wordsList);
        Map<String, Integer> map = new TreeMap<>();

        int max = 1;
        for (String str : set) {
            int frequency = Collections.frequency(wordsList, str);
            map.put(str, frequency);
            if (frequency > max) {
                max = frequency;
            }
        }
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            if (max == pair.getValue()) {
                System.out.printf("%s%n", pair.getKey());
            }
        }
    }

    static List<String> parseString(String s) {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            list.add(s.substring(matcher.start(), matcher.end()));
        }
        return list;
    }
}