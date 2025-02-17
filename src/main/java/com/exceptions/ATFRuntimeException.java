package com.exceptions;

public class ATFRuntimeException extends RuntimeException {
    public ATFRuntimeException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public ATFRuntimeException(Exception exceptionMessage) {
        super(exceptionMessage);
    }
}
