package com.rds.benchmarks.exceptions;

public class TestException extends Exception {
    @Override
    public synchronized Throwable fillInStackTrace() {
        return null;
    }
}
