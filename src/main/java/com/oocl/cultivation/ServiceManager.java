package com.oocl.cultivation;

import com.oocl.cultivation.Exception.NoParkingBoyException;
import com.oocl.cultivation.Exception.NoTicketException;
import com.oocl.cultivation.Exception.UnrecognizedTicketException;

import java.util.ArrayList;
import java.util.List;

public class ServiceManager extends ParkingBoy{
    private List<ParkingBoy> managementList;

    public ServiceManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
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

    public Car assignToFetchCar(ParkingBoy parkingBoy, ParkingTicket parkingTicket) {
        boolean noTicket = parkingTicket == null;
        if (noTicket) {
            throw new NoTicketException();
        }

        return managementList.stream()
                .filter(parkingBoy1 -> parkingBoy1 == parkingBoy)
                .findFirst()
                .orElseThrow(UnrecognizedTicketException::new)
                .fetch(parkingTicket);
    }
}
