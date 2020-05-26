package com.sbt.jscool.lesson05.atm.exception;

public class WrongPinException extends Exception {
    public WrongPinException(String message) {
        super(message);
    }
}

