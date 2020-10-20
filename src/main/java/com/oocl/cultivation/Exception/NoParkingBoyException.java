package com.oocl.cultivation.Exception;

public class NoParkingBoyException extends RuntimeException{
    public NoParkingBoyException() {
        super("Parking Boy does not exist!");
    }
}
