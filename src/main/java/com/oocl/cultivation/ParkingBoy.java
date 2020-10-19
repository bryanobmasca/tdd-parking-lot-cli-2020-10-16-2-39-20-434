package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        boolean noTicket = parkingTicket == null;
        if (noTicket){
            throw new NoTicketExecption("Please provide your parking ticket");
        }

        Car car = parkingLot.fetch(parkingTicket);
        boolean isTicketValid = car != null;
        if (isTicketValid){
            return car;
        }
        else{
            throw new UnrecognizedTicketException("Unrecognized parking ticket");
        }
    }
}
