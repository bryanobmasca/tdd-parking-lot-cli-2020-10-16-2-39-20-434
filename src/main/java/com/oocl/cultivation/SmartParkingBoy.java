package com.oocl.cultivation;

import com.oocl.cultivation.Strategy.parking.MostEmptyParking;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        parking = new MostEmptyParking();
    }

    @Override
    public ParkingTicket park(Car car) {
        return parking.park(car, parkingLots);
    }
}
