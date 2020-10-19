package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SmartParkingBoyTest {
    @Test
    void should_park_in_more_empty_slot_when_parking_given_first_level_capacity_is_2_and_second_level_capacity_is_3() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(asList(new ParkingLot(2), new ParkingLot(3)));
        //when
        smartParkingBoy.park(car1);
        smartParkingBoy.park(car2);
        smartParkingBoy.park(car3);
        //then
        assertEquals(1, smartParkingBoy.getParkingLotArrayList().get(0).getParkedCarsSize());
        assertEquals(2, smartParkingBoy.getParkingLotArrayList().get(1).getParkedCarsSize());
    }
}
