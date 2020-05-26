package com.sbt.jscool.lesson05.atm;

import com.sbt.jscool.lesson05.atm.exception.AccountNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class TerminalServer {
    private static final Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(1234, 1000);
        map.put(1277, 200);
        map.put(1111, 18000);
        map.put(3788, 1400);
        map.put(3000, 2000);
        map.put(4037, 800);
        map.put(5038, 700);
        map.put(6039, 12000);
        map.put(7041, 1900);
        map.put(8043, 2400);
    }

    public TerminalServer() {
    }

    public boolean isPinExist(int pin) {
        return map.containsKey(pin);
    }

    public int getBalance(int pin) throws AccountNotFoundException {
        if (isPinExist(pin)) {
            return map.get(pin);
        }
        throw new AccountNotFoundException("Учетная запись не найдена");
    }

    public boolean setBalance(int pin, int money) throws AccountNotFoundException {
        if (isPinExist(pin)) {
            Integer balance = map.get(pin);
            if ((balance + money) >= 0) {
                balance += money;
                map.put(pin, balance);
                return true;
            }
            return false;
        }
        throw new AccountNotFoundException("Учетная запись не найдена");
    }

    public boolean deposit(int pin, int money) throws AccountNotFoundException {
        return setBalance(pin, money);
    }

    public boolean withdraw(int pin, int money) throws AccountNotFoundException {
        return setBalance(pin, -money);
    }

    public boolean checkPin(int account) {
        return map.containsKey(account);
    }
}
