package com.sbt.jscool.lesson07;

/*
* Пример плагина
* */
public class PluginImp implements Plugin {
    @Override
    public void doUsefull() {
        System.out.println(this.getClass().getSimpleName() + " " + "loaded.");
    }
}
