package com.example.zoostorestorage.core.exception;

public class NegativeItemPriceException extends RuntimeException{

    private static final String MESSAGE = "The updated price must be greater than 0!";

    public NegativeItemPriceException() {
        super(MESSAGE);
    }
}
