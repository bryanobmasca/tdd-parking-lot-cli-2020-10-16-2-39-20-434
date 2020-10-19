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
        if (capacity > 0 ) {
            ParkingTicket ticket = new ParkingTicket();
            ticketCarMap.put(ticket, car);
            capacity--;
            return ticket;
        }
        else {
            throw new NoAvailableSlotException("Not enough position");
        }
    }

    public Car fetch(ParkingTicket parkingTicket) {
        car = ticketCarMap.get(parkingTicket);
        ticketCarMap.remove(parkingTicket);
        return car;
    }
}
