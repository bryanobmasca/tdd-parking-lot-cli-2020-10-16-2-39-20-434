package com.oocl.cultivation;

import com.oocl.cultivation.Exception.NoAvailableSlotException;
import com.oocl.cultivation.Exception.NoTicketExecption;
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
                .orElseThrow(() -> new NoAvailableSlotException("Not enough position"))
                .park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        boolean noTicket = parkingTicket == null;
        if (noTicket){
            throw new NoTicketExecption("Please provide your parking ticket");
        }
        ParkingLot parkingLot = getTicketInParkingLot(parkingTicket);
        return parkingLot.fetch(parkingTicket);
    }

    private ParkingLot getTicketInParkingLot(ParkingTicket parkingTicket) {
        return parkingLots.stream()
                .filter(p -> p.hasParkingTicket(parkingTicket))
                .findFirst()
                .orElseThrow(() -> new UnrecognizedTicketException("Unrecognized parking ticket"));
    }

    public List<ParkingLot> getParkingLotArrayList() {
        return parkingLots;
    }
}
