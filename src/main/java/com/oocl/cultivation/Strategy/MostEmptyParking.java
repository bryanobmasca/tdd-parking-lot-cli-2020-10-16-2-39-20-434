package com.oocl.cultivation.Strategy;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.Exception.NoAvailableSlotException;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;

import java.util.Comparator;
import java.util.List;

public class MostEmptyParking implements Parking {
    @Override
    public ParkingTicket park(Car car, List<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .max(Comparator.comparingDouble(ParkingLot::getAvailableCapacity))
                .orElseThrow(NoAvailableSlotException::new)
                .park(car);
    }
}
