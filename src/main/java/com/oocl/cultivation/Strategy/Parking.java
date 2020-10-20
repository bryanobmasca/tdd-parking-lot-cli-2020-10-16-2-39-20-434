package com.oocl.cultivation.Strategy;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;

import java.util.List;

public interface Parking {
    ParkingTicket park(Car car, List<ParkingLot> parkingLots);
}
