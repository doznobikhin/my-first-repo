package com.sbt.jscool.lesson02;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
На лекции решили пропустить.
 */

public class Solution5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("string" + i);
        }

        ListIterator<String> listIterator = list.listIterator(list.size());

        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

    }
}
