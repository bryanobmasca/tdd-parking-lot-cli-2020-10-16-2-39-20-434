package com.oocl.cultivation.Strategy;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.Exception.NoAvailableSlotException;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;

import java.util.List;

public class SequentialParking implements Parking{
    @Override
    public ParkingTicket park(Car car, List<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .findFirst()
                .orElseThrow(NoAvailableSlotException::new)
                .park(car);
    }
}
