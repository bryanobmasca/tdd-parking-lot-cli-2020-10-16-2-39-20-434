package com.oocl.cultivation;

import com.oocl.cultivation.Exception.NoParkingBoyException;

import java.util.ArrayList;
import java.util.List;

public class ServiceManager {
    private List<ParkingBoy> managementList;

    public ServiceManager() {
        managementList = new ArrayList<>();
    }

    public void addToManagementList(ParkingBoy parkingBoy) {
        managementList.add(parkingBoy);
    }

    public List<ParkingBoy> getManagementList() {
        return managementList;
    }

    public ParkingTicket assignToParkCar(ParkingBoy parkingBoy, Car car) {
        return managementList.stream()
                .filter(parkingBoy1 -> parkingBoy1 == parkingBoy)
                .findFirst()
                .orElseThrow(NoParkingBoyException::new)
                .park(car);
    }
}
