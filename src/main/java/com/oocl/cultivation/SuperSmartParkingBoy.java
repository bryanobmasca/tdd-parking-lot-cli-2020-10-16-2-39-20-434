package com.oocl.cultivation;

import com.oocl.cultivation.Strategy.parking.LargestAvailableRate;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        parking = new LargestAvailableRate();
    }

    @Override
    public ParkingTicket park(Car car) {
        return parking.park(car, parkingLots);
    }
}
