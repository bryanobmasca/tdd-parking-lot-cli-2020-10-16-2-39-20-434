package com.oocl.cultivation.Exception;

public class NoTicketExecption extends RuntimeException{
    public NoTicketExecption() {
        super("Please provide your parking ticket");
    }
}
