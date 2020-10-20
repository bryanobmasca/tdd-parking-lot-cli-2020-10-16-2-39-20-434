package com.oocl.cultivation.Exception;

public class UnrecognizedTicketException extends RuntimeException{
    public UnrecognizedTicketException() {
        super("Unrecognized parking ticket");
    }
}
