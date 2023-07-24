package com.example.zoostorestorage.core.exception;

public class NoSuchItemException extends RuntimeException{
    private static final String MESSAGE = "This item does not exist!";

    public NoSuchItemException() {
        super(MESSAGE);
    }
}
