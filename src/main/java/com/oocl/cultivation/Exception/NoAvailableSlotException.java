package com.oocl.cultivation.Exception;

public class NoAvailableSlotException extends RuntimeException {
    public NoAvailableSlotException() {
        super("Not enough position");
    }
}
