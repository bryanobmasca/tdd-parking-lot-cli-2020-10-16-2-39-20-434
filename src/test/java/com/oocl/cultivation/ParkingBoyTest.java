package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class ParkingBoyTest {
    @Test
    public void should_return_parking_ticket_when_parked_given_a_car_to_parking_boy() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        //when
        ParkingTicket ticket = parkingBoy.park(car);
        //then
        assertNotNull(ticket);
    }
    
    @Test
    public void should_return_correct_car_when_fetching_given_correct_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket = parkingBoy.park(car);
        //when
        Car fetchedCar = parkingBoy.fetch(parkingTicket);
        //then
        assertSame(car, fetchedCar);
    }
    
    @Test
    public void should_two_correct_car_when_fetching_given_two_correct_ticket() {
        //given
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        ParkingTicket firstTicket = parkingBoy.park(firstCar);
        ParkingTicket secondTicket = parkingBoy.park(secondCar);
        //when
        Car firstFetchedCar = parkingBoy.fetch(firstTicket);
        Car secondFetchedCar = parkingBoy.fetch(secondTicket);
        //then
        assertSame(firstCar, firstFetchedCar);
        assertSame(secondCar, secondFetchedCar);
    }
    
    @Test
    public void should_return_no_car_when_fetching_given_a_wrong_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        parkingBoy.park(car);
        ParkingTicket wrongTicket = new ParkingTicket();
        //when
        Car fetchedCar = parkingBoy.fetch(wrongTicket);
        //then
        assertSame(null, fetchedCar);
    }
    
    @Test
    public void should_return_no_car_when_fetching_given_no_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        parkingBoy.park(car);
        //when
        Car fetchedCar = parkingBoy.fetch(null);
        //then
        assertSame(null, fetchedCar);
    }

    @Test
    public void should_return_no_car_when_fetching_given_ticket_has_been_used() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket = parkingBoy.park(car);
        parkingBoy.fetch(parkingTicket);
        //when
        Car secondFetchedCar = parkingBoy.fetch(parkingTicket);
        //then
        assertSame(null, secondFetchedCar);
    }
    
    @Test
    public void should_return_park_failed_when_parking_given_no_available_parking_lot() {
        //given
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        parkingBoy.park(firstCar);
        //when
        ParkingTicket secondTicket = parkingBoy.park(secondCar);
        //then
        assertSame(null, secondTicket);
    }
}
