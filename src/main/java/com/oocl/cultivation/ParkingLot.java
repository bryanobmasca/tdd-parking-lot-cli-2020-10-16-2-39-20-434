package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static final int DEFAULT_CAPACITY = 10;
    private final int capacity;
    private final Map<ParkingTicket, Car> ticketCarMap = new HashMap<>();

    public ParkingLot(int parkingSlot) {
        this.capacity = parkingSlot;
    }

    public ParkingLot() {
        this.capacity = DEFAULT_CAPACITY;
    }

    ParkingTicket park(Car car) {
        ParkingTicket ticket = new ParkingTicket();
        ticketCarMap.put(ticket, car);
        return ticket;
    }

    Car fetch(ParkingTicket parkingTicket) {
        Car car = ticketCarMap.get(parkingTicket);
        ticketCarMap.remove(parkingTicket);
        return car;
    }

    boolean isFull() {
        return ticketCarMap.size() == capacity;
    }

    boolean hasParkingTicket(ParkingTicket parkingTicket) {
        return ticketCarMap.containsKey(parkingTicket);
    }

    public int getParkedCarsSize() {
        return ticketCarMap.size();
    }

    private int getCapacity() {
        return capacity;
    }

    int getAvailableCapacity() {
        return getCapacity() - getParkedCarsSize();
    }

    double getAvailablePositionRate() {
        return (double) getAvailableCapacity() / capacity;
    }
}
