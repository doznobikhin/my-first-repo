package com.sbt.jscool.tasks._2061;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<String> list = new ArrayList<>(n - 1);
        for (int i = 0; i < n - 1; i++) {
            list.add(reader.readLine());
        }

        Map<String, Folder> folders = new HashMap<>();
        Folder main = new Folder("main", 0);
        folders.put(main.name, main);

        StringTokenizer st;
        for (String str : list) {
            st = new StringTokenizer(str);
            String childName = st.nextToken();
            String parentName = st.nextToken();
            if (folders.containsKey(parentName)) {
                Folder parentFolder = folders.get(parentName);
                Folder childFolder = new Folder(childName, parentFolder.level + 1);
                parentFolder.children.add(childFolder);
                folders.put(childName, childFolder);
            }
        }

        System.out.println(main);
    }

    public static class Folder implements Comparable<Folder> {
        private String name;
        private Set<Folder> children;
        private int level;

        public Folder(String name, int level) {
            this.name = name;
            this.level = level;
            this.children = new TreeSet<>();
        }

        @Override
        public int compareTo(Folder o) {
            return this.name.compareTo(o.name);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(indent(level * 2));
            sb.append(name);
            sb.append("\n");
            for (Folder folder : children) {
                sb.append(folder);
            }
            return sb.toString();
        }

        private String indent(int n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
    }

}
