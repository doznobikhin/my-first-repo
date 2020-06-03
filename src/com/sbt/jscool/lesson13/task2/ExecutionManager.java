package com.sbt.jscool.lesson13.task2;

public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}

