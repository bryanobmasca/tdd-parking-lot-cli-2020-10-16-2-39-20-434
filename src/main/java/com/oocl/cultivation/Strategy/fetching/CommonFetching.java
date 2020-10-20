package com.oocl.cultivation.Strategy.fetching;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.Exception.NoTicketException;
import com.oocl.cultivation.Exception.UnrecognizedTicketException;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;
import com.oocl.cultivation.Strategy.Fetching;

import java.util.List;

public class CommonFetching implements Fetching {
    @Override
    public Car fetch(ParkingTicket parkingTicket, List<ParkingLot> parkingLots) {
        boolean noTicket = parkingTicket == null;
        if (noTicket) {
            throw new NoTicketException();
        }

        return parkingLots.stream()
                .filter(p -> p.hasParkingTicket(parkingTicket))
                .findFirst()
                .orElseThrow(() -> new UnrecognizedTicketException())
                .fetch(parkingTicket);
    }
}
