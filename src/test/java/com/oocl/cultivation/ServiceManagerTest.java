package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceManagerTest {
    @Test
    public void should_return_1_when_get_management_list_given_1_parking_boy_is_added_to_the_list() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(asList(new ParkingLot()));
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.addToManagementList(parkingBoy);
        //when
        List<ParkingBoy> parkingBoyList = serviceManager.getManagementList();
        ;
        //then
        assertEquals(1, parkingBoyList.size());
    }

    @Test
    public void should_return_a_ticket_when_parking_given_service_manager_assigned_parking_boy_to_park_a_car() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(asList(new ParkingLot()));
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.addToManagementList(parkingBoy);
        //when
        ParkingTicket parkingTicket = serviceManager.assignToParkCar(parkingBoy, car);
        //then
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_correct_car_when_fetching_given_correct_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(asList(new ParkingLot()));
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.addToManagementList(parkingBoy);
        ParkingTicket parkingTicket = serviceManager.assignToParkCar(parkingBoy, car);
        //when
        Car actualCar = serviceManager.assignToFetchCar(parkingBoy, parkingTicket);
        //then
        assertSame(car, actualCar);
    }
}
