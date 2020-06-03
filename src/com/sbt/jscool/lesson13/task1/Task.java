package com.sbt.jscool.lesson13.task1;

import java.util.concurrent.Callable;


/*
 * Данный класс в конструкторе принимает экземпляр java.util.concurrent.Callable. Callable похож на Runnuble,
 * но результатом его работы является объект (а не void).
 * Ваша задача реализовать метод get() который возвращает результат работы Callable. Выполнение callable должен
 * начинать тот поток, который первый вызвал метод get(). Если несколько потоков одновременно вызывают этот метод,
 * то выполнение должно начаться только в одном потоке, а остальные должны ожидать конца выполнения (не нагружая
 * процессор).
 * Если при вызове get() результат уже просчитан, то он должен вернуться сразу, (даже без задержек на вход в
 * синхронизированную область).
 * Если при просчете результата произошел Exception, то всем потокам при вызове get(), надо кидать этот Exception,
 * обернутый в ваш RuntimeException (подходящее название своему ексепшену придумайте сами).
 * */

public class Task<T> {
    private Callable<? extends T> callable;
    private volatile T result;
    private volatile RuntimeException exception;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() {
        if (result == null && exception == null) {
            synchronized (this) {
                if (result == null && exception == null) {
                    try {
                        T tmpResult = callable.call();
                        result = tmpResult;
                    } catch (Exception e) {
                        RuntimeException tmpE = new CallableException("get method exception", e);
                        exception = tmpE;
                    }
                }
            }
        }
        if (exception != null) {
            throw exception;
        }
        return result;
    }

}

