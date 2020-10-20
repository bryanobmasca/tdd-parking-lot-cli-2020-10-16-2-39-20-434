package com.oocl.cultivation;

import com.oocl.cultivation.Exception.NoAvailableSlotException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    private final Map<ParkingTicket, Car> ticketCarMap = new HashMap<>();

    public ParkingLot(int parkingSlot) {
        this.capacity = parkingSlot;
    }

    public ParkingLot() {
        this.capacity = 10;
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

    double getAvailableCapacity() {
        return getCapacity() - getParkedCarsSize();
    }

    double getAvailablePositionRate() {
        return getAvailableCapacity() / capacity;
    }
}
