package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SuperSmartParkingBoyTest {
    @Test
    void should_park_in_larger_available_slot_when_parking_given_first_level_capacity_is_2_having_1_parked_car_and_second_level_capacity_is_3_having_no_parked_car() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(asList(new ParkingLot(2), new ParkingLot(3)));
        //when
        superSmartParkingBoy.park(car1);
        superSmartParkingBoy.park(car2);
        superSmartParkingBoy.park(car3);
        //then
        assertEquals(1, superSmartParkingBoy.getParkingLotArrayList().get(0).getParkedCarsSize());
        assertEquals(2, superSmartParkingBoy.getParkingLotArrayList().get(1).getParkedCarsSize());
    }
}
