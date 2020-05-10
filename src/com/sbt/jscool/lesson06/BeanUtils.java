package com.sbt.jscool.lesson06;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) {
        Method[] methods = from.getClass().getDeclaredMethods();
        for (Method getMethod : methods) {
            if (isGetter(getMethod)) {
                String getMethodName = getMethod.getName();
                String setMethodName = "set" + getMethodName.substring(3);
                String fieldName = getMethodName.substring(3).toLowerCase();

                try {
                    // было бы проще найти все setters для from и найдя соот-й getter для to
                    // вызвать setter
                    Field field = to.getClass().getDeclaredField(fieldName);
                    Method setMethod = to.getClass().getDeclaredMethod(setMethodName, field.getType());
//                    Class[] parameterTypes = setMethod.getParameterTypes();  // parameterTypes[0]
                    Object returnObject = getMethod.invoke(from, null);
                    if (field.getType().isInstance(returnObject)) {
                        setMethod.invoke(to, returnObject);
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) return false;
        if (method.getParameterTypes().length != 0) return false;
        if (void.class.equals(method.getReturnType())) return false;
        return true;
    }

//    private static boolean isSetter(Method method) {
//        if (!method.getName().startsWith("set")) return false;
//        if (method.getParameterTypes().length != 1) return false;
//        return true;
//    }
}