package com.oocl.cultivation;

public class NoAvailableSlotException extends RuntimeException {
    public NoAvailableSlotException(String message) {
        super(message);
    }
}
