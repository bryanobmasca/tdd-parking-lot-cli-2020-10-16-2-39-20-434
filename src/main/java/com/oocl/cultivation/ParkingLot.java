package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int parkingSlot;
    private Car car;
    private final Map<ParkingTicket, Car> ticketCarMap = new HashMap<>();

    public ParkingLot(int parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public ParkingTicket park(Car car) {
        if (parkingSlot > 0 ) {
            ParkingTicket ticket = new ParkingTicket();
            ticketCarMap.put(ticket, car);
            parkingSlot--;
            return ticket;
        }
        else {
            return null;
        }
    }

    public Car fetch(ParkingTicket parkingTicket) {
        car = ticketCarMap.get(parkingTicket);
        ticketCarMap.remove(parkingTicket);
        return car;
    }
}
