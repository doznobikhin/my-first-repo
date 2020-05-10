package com.sbt.jscool.lesson06;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/*
* Задание 1.
Для класса String получить и вывести на экран:
1.	Все модификаторы типа
2.	Имя пакета
3.	Классы иерархии
4.	Реализуемые интерфейсы для класса и для его родителей
*/
public class Solution01 {
    public static void main(String[] args) {
        Class<?> clazz = String.class;
        System.out.println("class modifiers: " + Modifier.toString(clazz.getModifiers()));

        System.out.println("package: " + clazz.getPackage().getName());

        System.out.println("class hierarchy:");
        while (clazz != null) {
            System.out.println(clazz);
            clazz = clazz.getSuperclass();
        }

        System.out.println("implemented interfaces: ");
        clazz = String.class;
        while (clazz != null) {
            Class<?>[] interfaces = clazz.getInterfaces();
            System.out.println(clazz.getSimpleName() + ": " + Arrays.toString(interfaces));
            clazz = clazz.getSuperclass();
        }
    }
}
