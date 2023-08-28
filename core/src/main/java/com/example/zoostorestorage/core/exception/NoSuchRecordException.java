package com.example.zoostorestorage.core.exception;

public class NoSuchRecordException extends RuntimeException{
    private static final String MESSAGE = "This record does not exist!";

    public NoSuchRecordException() {
        super(MESSAGE);
    }
}
