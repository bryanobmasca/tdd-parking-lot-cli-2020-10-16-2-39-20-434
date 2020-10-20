package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceManagerTest {
    @Test
    public void should_return_1_when_get_management_list_given_1_parking_boy_is_added_to_the_list() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(asList(new ParkingLot()));
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.addToManagementList(parkingBoy);
        //when
        List<ParkingBoy> parkingBoyList = serviceManager.getManagementList();;
        //then
        assertEquals(1, parkingBoyList.size());
    }
}
