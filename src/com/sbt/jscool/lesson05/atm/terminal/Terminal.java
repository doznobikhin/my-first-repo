package com.sbt.jscool.lesson05.atm.terminal;

import com.sbt.jscool.lesson05.atm.exception.WrongPinException;

public interface Terminal {
    void getBalance() throws WrongPinException;

    void deposit(int money) throws WrongPinException;

    void withdraw(int money) throws WrongPinException;
}

