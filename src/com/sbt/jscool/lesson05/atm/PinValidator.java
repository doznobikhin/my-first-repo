package com.sbt.jscool.lesson05.atm;

import com.sbt.jscool.lesson05.atm.exception.AccountIsLockedException;

import java.time.LocalDateTime;

public class PinValidator {
    private final TerminalServer server;

    private boolean pinEntered;
    private int attemptsNumber = 3;
    private LocalDateTime lockTime = LocalDateTime.now();


    public PinValidator(TerminalServer server) {
        this.server = server;
    }

    public boolean isPinEntered() {
        return pinEntered;
    }

    public void enterPIN(int account) throws AccountIsLockedException {
        if (pinEntered) {
            return;
        }
        if (String.valueOf(account).length() != 4) {
            // неверный пин
            System.out.println("Введен неверный пин код");
            return;
        }

        LocalDateTime now = LocalDateTime.now().plusNanos(1);
        if (!now.isAfter(lockTime)) {
            throw new AccountIsLockedException("Аккаунт будет разблокирован " + lockTime);
        }

        // подключиться к серверу   успешно или неуспешно
        // проверить pin            успешно или неуспешно
        // считаем, что подключение к серверу успешно, тогда проверем только пин
        if (server.checkPin(account)) {
            pinEntered = true;
            attemptsNumber = 3;
            System.out.println("ПИН-код введен успешно");
        } else {
            attemptsNumber--;
            System.out.println("Неверный ПИН-код. Осталось попыток " + attemptsNumber);
            if (attemptsNumber == 0) {
                lockTime = LocalDateTime.now().plusSeconds(5);
                attemptsNumber = 3;
            }
        }
    }
}
