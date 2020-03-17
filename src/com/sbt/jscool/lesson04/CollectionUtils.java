package com.sbt.jscool.lesson04;

import java.util.*;

public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, T element) {
        //T element = (T) o;
        return source.indexOf(element);
    }

    public static <T> List<T> limit(List<T> source, int size) {
        return source.subList(0, size - 1);
    }

    public static <T> void add(List<T> source, T element) {
        //T element = (T) o;
        source.add(element);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T object : c2) {
            if (c1.contains(object)) {
                return true;
            }
        }
        return false;
    }

    /*public static <T extends Comparable<? super T>> List<T> range(List<T> list, T min, T max) {
        List<T> copy = new ArrayList<>(list);
        Collections.<T>sort(copy);
        return copy.subList(copy.indexOf(min), copy.indexOf(max) + 1);
    }*/

    public static <T> List<T> range(List<T> list, T min, T max) {
        return range(list,min,max, null);
    }

    public static <T> List<T> range(List<T> list, T min, T max, Comparator<? super T> comparator) {
        List<T> copy = new ArrayList<>(list);
        //Collections.sort(copy, comparator);
        copy.sort(comparator);
        return copy.subList(copy.indexOf(min), copy.indexOf(max) + 1);
    }

}


