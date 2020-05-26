package com.sbt.jscool.lesson05.atm.terminal;

import com.sbt.jscool.lesson05.atm.PinValidator;
import com.sbt.jscool.lesson05.atm.TerminalServer;
import com.sbt.jscool.lesson05.atm.exception.AccountIsLockedException;
import com.sbt.jscool.lesson05.atm.exception.AccountNotFoundException;
import com.sbt.jscool.lesson05.atm.exception.WrongPinException;
import com.sbt.jscool.lesson05.atm.view.View;

class TerminalImpl implements Terminal {
    private final TerminalServer server;
    private final PinValidator pinvalidator;
    private final View view = new View();
    private int account;

    public TerminalImpl(TerminalServer server) {
        this.server = server;
        this.pinvalidator = new PinValidator(server);
    }

    public void enterPIN(int account) throws AccountIsLockedException {
        pinvalidator.enterPIN(account);
        if (pinvalidator.isPinEntered()) {
            this.account = account;
        }
    }

    public void getBalance() throws WrongPinException {
        if (!pinvalidator.isPinEntered()) {
            throw new WrongPinException("PIN not entered");
        }
        // запросить баланс у сервера
        try {
            int balance = server.getBalance(account);
            view.showMessage(balance);
        } catch (AccountNotFoundException e) {
            view.showMessage("Проблема с БД. Попробуйте выполнить операцию позже.");
        }
    }

    public void deposit(int money) throws WrongPinException {
        if (!pinvalidator.isPinEntered()) {
            throw new WrongPinException("PIN not entered");
        }
        if (!String.valueOf(money).endsWith("00")) {
            view.showMessage("сумма не кратна 100");
        } else if (money < 0) {
            view.showMessage("сумма меньше 0");
        } else {
            // соединиться с сервером и положить деньги на счет
            try {
                if (server.deposit(account, money)) {
                    view.showMessage("Зачислено на счет " + money);
                } else {
                    view.showMessage("Невозможно выполнить операцию");
                }
            } catch (AccountNotFoundException e) {
                view.showMessage("Проблема с БД. Попробуйте выполнить операцию позже.");
            }
        }
    }

    public void withdraw(int money) throws WrongPinException {
        if (!pinvalidator.isPinEntered()) {
            throw new WrongPinException("PIN not entered");
        }
        if (!String.valueOf(money).endsWith("00")) {
            view.showMessage("сумма не кратна 100");
        } else if (money < 0) {
            view.showMessage("сумма меньше 0");
        } else {
            // соединиться с сервером и снять деньги со счета
            try {
                if (server.withdraw(account, money)) {
                    System.out.printf("%s %d%n", "Выдано со счета ", money);
                } else {
                    view.showMessage("Недостаточно средств на счете");
                }
            } catch (AccountNotFoundException e) {
                view.showMessage("Проблема с БД. Попробуйте выполнить операцию позже.");
            }
        }
    }

    public static void main(String[] args) throws WrongPinException, AccountIsLockedException {
        TerminalImpl terminal = new TerminalImpl(new TerminalServer());
//         terminal.enterPIN(1234);
//        terminal.getBalance();
//        terminal.withdraw(200);
//        terminal.withdraw(900);
//        terminal.getBalance();
        terminal.enterPIN(1243);
        terminal.enterPIN(1243);
        terminal.enterPIN(1243);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        terminal.enterPIN(1234);
        terminal.getBalance();
//        terminal.enterPIN(1243);

//        terminal.withdraw(100);
//        terminal.deposit(200);
//        terminal.getBalance();
    }
}