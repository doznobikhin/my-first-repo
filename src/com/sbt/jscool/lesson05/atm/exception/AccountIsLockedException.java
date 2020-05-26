package com.sbt.jscool.lesson05.atm.exception;

public class AccountIsLockedException extends Exception {
    public AccountIsLockedException(String message) {
        super(message);
    }
}
