package com.oocl.cultivation;

import com.oocl.cultivation.Strategy.CommonFetching;
import com.oocl.cultivation.Strategy.Fetching;
import com.oocl.cultivation.Strategy.Parking;
import com.oocl.cultivation.Strategy.SequentialParking;

import java.util.List;

public class ParkingBoy {

    protected List<ParkingLot> parkingLots;
    protected Parking parking;
    protected final Fetching fetching;


    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        parking = new SequentialParking();
        fetching = new CommonFetching();
    }

    public ParkingTicket park(Car car) {
        return parking.park(car, parkingLots);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return fetching.fetch(parkingTicket, parkingLots);
    }

    public List<ParkingLot> getParkingLotArrayList() {
        return parkingLots;
    }
}
