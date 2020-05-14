package com.sbt.jscool.lesson07;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/*
 * В метод Plugin load(String, String)
 * передаем название плагина (== названию папки)
 * и имя класса, который нужно загрузить
 *
 * можно еще добавить метод, который обходит pluginRootDirectory
 * находит все плагины и лежащие внутри каждого из них классы
 * последовательно вызывает метод Plugin load(String, String)
 * для каждого плагина/класса
 * */

public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, MalformedURLException {
        //todo
        File file = new File(pluginRootDirectory + "\\" + pluginName);

        // convert the file to URL format
        URL url = file.toURI().toURL();
        URL[] urls = new URL[]{url};

        // load this folder into Class loader
        ClassLoader cl = new URLClassLoader(urls);

        // load the pluginClassName class in pluginRootDirectory + "\\" + pluginName
        Class<?> clazz = cl.loadClass(pluginClassName);

        return (Plugin) clazz.newInstance();
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, MalformedURLException {
        PluginManager pm = new PluginManager("D:\\school\\lesson07_classloader\\");
        Plugin plugin1 = pm.load("sonar", "PluginImp");
        Plugin plugin2 = pm.load("stern", "PluginImp");

        plugin1.doUsefull(); // sout:    PluginImp loaded.
        plugin2.doUsefull(); // sout:    PluginImp LOADED.
    }
}

