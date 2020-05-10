package com.sbt.jscool.lesson06;

/*
•	Вывести на консоль все методы класса, включая все родительские методы (и приватные тоже).
•	Вывести все геттеры класса.
•	Проверить что все строковые константы имеют значения, равные их имени
public static final String MONDAY = "MONDAY"
•	Реализовать кэширующий прокси
*/

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Solution03 {
    //    public static final String MONDAY = "MONDAY";
    public static final Object MONDAY1 = "MONDAY1";
    private boolean allConsNames = true;

    public static void main(String[] args) throws IllegalAccessException {
        Solution03 sol = new Solution03();
        Class<?> clazz = sol.getClass();

        List<String> getters = new ArrayList<>();
        // All class methods, all superclass methods, and so on
        while (clazz != null) {
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
                if (isGetter(method)) {
                    getters.add(method.getName());
                }
            }
            clazz = clazz.getSuperclass();
        }
        System.out.println(getters);

        clazz = sol.getClass();
        Field[] fields = clazz.getDeclaredFields();
        int constantsCount = 0;
        for (Field field : fields) {
            String modifier = Modifier.toString(field.getModifiers());
            // Type variable = object
            // 1) Type.isInstance(new String())
            // 2) String.class.isInstance(object)
//            if (modifier.contains("static final") && field.getType().isInstance(new String())
//            && !field.getType().isInstance(new Object())) {
            if (modifier.contains("static final") && String.class.isInstance(field.get(sol))) {
                constantsCount++;
                if (!field.getName().equals(field.get(sol))) {
                    sol.allConsNames = false;
                    break;
                }
            }
        }
        if (constantsCount == 0) {
            sol.allConsNames = false;
        }
        System.out.println(sol.allConsNames);
    }

    private static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) return false;
        if (method.getParameterTypes().length != 0) return false;
        if (void.class.equals(method.getReturnType())) return false;
        return true;
    }
}
