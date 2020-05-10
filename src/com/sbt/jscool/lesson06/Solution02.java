package com.sbt.jscool.lesson06;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;

/*
 Получить все возможные типы-параметры в объекте этого класса.
public class Runtime<T extends Number>
				implements Callable<Double>
*/
public class Solution02 {
    public static void main(String[] args) {
        Class<?> clazz = Runtime.class;

        System.out.println("Class: ");
        System.out.println(Modifier.toString(clazz.getModifiers()) + " "
                + clazz.getSimpleName() + " "
                + Arrays.toString(clazz.getTypeParameters()) + " "
                + Arrays.toString(clazz.getTypeParameters()[0].getBounds()) + "\n");


        System.out.println("Interfaces: ");
        Type[] interfaceTypes = clazz.getGenericInterfaces();
        for (Type interfaceType : interfaceTypes) {
            System.out.println(interfaceType);
        }
        System.out.println();

        System.out.println("Fields: ");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getGenericType() + " " + field.getName());
        }
        System.out.println();

        System.out.println("Methods: ");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Type returnType = method.getGenericReturnType();
            Class<?>[] params = method.getParameterTypes();
            System.out.println(Modifier.toString(method.getModifiers()) + " "
                    + returnType + " "
                    + method.getName() + " "
                    + Arrays.toString(params) + "\n");
        }
    }
}
