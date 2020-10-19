package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {

    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {
        ParkingLot parkingLot = getAvailableParkingLot();
        return parkingLot.park(car);
    }

    private ParkingLot getAvailableParkingLot() {
        return parkingLots.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .findFirst()
                .orElseThrow(() -> new NoAvailableSlotException("Not enough position"));
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
}
