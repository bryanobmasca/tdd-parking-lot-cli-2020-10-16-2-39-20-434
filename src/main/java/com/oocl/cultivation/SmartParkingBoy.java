package com.oocl.cultivation;

import com.oocl.cultivation.Exception.NoAvailableSlotException;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy{
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        ParkingLot parkingLot = getAvailableParkingLot();
        return parkingLot.park(car);
    }
    private ParkingLot getAvailableParkingLot() {
        return parkingLots.stream()
                .max(Comparator.comparingDouble(ParkingLot::getAvailableCapacity))
                .orElseThrow(() -> new NoAvailableSlotException("Not enough position"));
    }
}
