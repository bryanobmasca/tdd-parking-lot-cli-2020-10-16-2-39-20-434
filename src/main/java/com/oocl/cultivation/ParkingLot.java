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
        if (isFull()) {
            throw new NoAvailableSlotException("Not enough position");
        } else {
            ParkingTicket ticket = new ParkingTicket();
            ticketCarMap.put(ticket, car);
            return ticket;
        }
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
}
