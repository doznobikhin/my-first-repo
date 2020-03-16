package com.sbt.jscool.lesson04;

import java.util.HashMap;
import java.util.Map;

public class CountMapImp<E> implements CountMap<E> {
    private Map<E, Integer> map;

    public CountMapImp() {
        this.map = new HashMap<>();
    }

    @Override
    public void add(E e) {
        if (map.containsKey(e)) {
            map.put(e, map.get(e) + 1);
        } else {
            map.put(e, 1);
        }
    }

    @Override
    public int getCount(E e) {
        /*if (map.containsKey(e)) {
            return map.get(e);
        }
        return 0;*/
        //return map.containsKey(e) ? map.get(e) : 0;
        return map.getOrDefault(e,0);
    }

    @Override
    public int remove(E e) {
        /*if (map.containsKey(e)) {
            return map.remove(e);
        }
        return 0;*/
        return map.containsKey(e) ? map.remove(e) : 0;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<? extends E> source) {
        Map<? extends E, Integer> mapTmp = source.toMap();
        for (Map.Entry<? extends E, Integer> pair : mapTmp.entrySet()) {
            E key = pair.getKey();
            Integer value = pair.getValue();
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + value);
            } else {
                map.put(key, value);
            }
        }
    }

    @Override
    public Map<E, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<? super E, Integer> destination) {
        for (Map.Entry<? extends E, Integer> pair : map.entrySet()) {
            E key = pair.getKey();
            Integer value = pair.getValue();
            destination.put(key, value);
        }
    }

    public static void main(String[] args) {
        CountMapImp<Integer> countMapImp = new CountMapImp<>();
        countMapImp.add(1);
        countMapImp.add(1);
        countMapImp.add(1);
        countMapImp.add(2);
        countMapImp.add(2);
        System.out.println(countMapImp.getCount(1));
        System.out.println(countMapImp.getCount(2));
        System.out.println(countMapImp.getCount(3));
        System.out.println(countMapImp.size());
        System.out.println(countMapImp.remove(1));
        System.out.println(countMapImp.remove(1));
        CountMap<Integer> countMapImp2 = new CountMapImp<>();
        countMapImp.add(5);
        countMapImp.add(10);
        countMapImp.add(10);
        countMapImp.add(20);
        countMapImp.add(20);
        countMapImp.add(20);

        System.out.println(countMapImp.size());
        countMapImp.addAll(countMapImp2);
        System.out.println(countMapImp.size());
    }
}
