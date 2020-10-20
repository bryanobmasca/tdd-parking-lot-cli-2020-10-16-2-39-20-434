package com.oocl.cultivation;

import com.oocl.cultivation.Exception.NoAvailableSlotException;
import com.oocl.cultivation.Exception.NoTicketException;
import com.oocl.cultivation.Exception.UnrecognizedTicketException;

import java.util.List;

public class ParkingBoy {

    protected List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {
        return parkingLots.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .findFirst()
                .orElseThrow(NoAvailableSlotException::new)
                .park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
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

    public List<ParkingLot> getParkingLotArrayList() {
        return parkingLots;
    }
}
