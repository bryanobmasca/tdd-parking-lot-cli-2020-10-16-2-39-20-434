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

    public ParkingTicket park(Car car) {
        ParkingTicket ticket = new ParkingTicket();
        ticketCarMap.put(ticket, car);
        return ticket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        Car car = ticketCarMap.get(parkingTicket);
        ticketCarMap.remove(parkingTicket);
        return car;
    }

    public boolean isFull() {
        return ticketCarMap.size() == capacity;
    }

    public boolean hasParkingTicket(ParkingTicket parkingTicket) {
        return ticketCarMap.containsKey(parkingTicket);
    }

    public int getParkedCarsSize() {
        return ticketCarMap.size();
    }

    private int getCapacity() {
        return capacity;
    }

    public int getAvailableCapacity() {
        return getCapacity() - getParkedCarsSize();
    }

    public double getAvailablePositionRate() {
        return (double) getAvailableCapacity() / capacity;
    }
}
