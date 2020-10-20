package com.oocl.cultivation.Strategy;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;

import java.util.List;

public interface Fetching {
    Car fetch(ParkingTicket parkingTicket, List<ParkingLot> parkingLotList);
}
