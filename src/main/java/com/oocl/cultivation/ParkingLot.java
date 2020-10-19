package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    private Car car;
    private final Map<ParkingTicket, Car> ticketCarMap = new HashMap<>();

    public ParkingLot(int parkingSlot) {
        this.capacity = parkingSlot;
    }

    public ParkingLot() {
        this.capacity = 10;
    }

    public ParkingTicket park(Car car) {
        if (isFull()) {
            throw new NoAvailableSlotException("Not enough position");
        }
        else {
            ParkingTicket ticket = new ParkingTicket();
            ticketCarMap.put(ticket, car);
            return ticket;
        }
    }

    public Car fetch(ParkingTicket parkingTicket) {
        car = ticketCarMap.get(parkingTicket);
        ticketCarMap.remove(parkingTicket);
        return car;
    }

    public boolean isFull() {
        return ticketCarMap.size() == capacity;
    }

    public boolean hasParkingTicket(ParkingTicket parkingTicket) {
        return ticketCarMap.containsKey(parkingTicket);
    }
}
