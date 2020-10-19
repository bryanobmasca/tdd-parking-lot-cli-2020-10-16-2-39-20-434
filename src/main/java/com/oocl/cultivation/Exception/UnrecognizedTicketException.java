package com.oocl.cultivation.Exception;

public class UnrecognizedTicketException extends RuntimeException{
    public UnrecognizedTicketException(String message) {
        super(message);
    }
}
