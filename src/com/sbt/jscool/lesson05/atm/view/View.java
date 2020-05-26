package com.sbt.jscool.lesson05.atm.view;

public class View {

    public void requestPIN() {
        showMessage("Введите ПИН-код (четыре цифры)");
    }

    public void showBalance(int money) {
        showMessage("Остаток средств на счете: " + money);
    }

    public void showMessage(String s) {
        System.out.println(s);
    }

    public void showMessage(int i) {
        System.out.println(i);
    }


}
