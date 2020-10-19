package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    public void should_return_parking_ticket_when_parked_given_a_car_to_parking_boy() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(asList(new ParkingLot()));
        //when
        ParkingTicket ticket = parkingBoy.park(car);
        //then
        assertNotNull(ticket);
    }
    
    @Test
    public void should_return_correct_car_when_fetching_given_correct_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(asList(new ParkingLot()));
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
        ParkingBoy parkingBoy = new ParkingBoy(asList(new ParkingLot()));
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
        ParkingBoy parkingBoy = new ParkingBoy(asList(new ParkingLot()));
        parkingBoy.park(car);
        ParkingTicket wrongTicket = new ParkingTicket();
        //when
        RuntimeException exception = assertThrows(UnrecognizedTicketException.class, () -> {
            Car fetchedCar = parkingBoy.fetch(wrongTicket);
        });
        //then
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }
    
    @Test
    public void should_return_no_car_when_fetching_given_no_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(asList(new ParkingLot()));
        parkingBoy.park(car);
        //when
        RuntimeException exception = assertThrows(NoTicketExecption.class, ()->{
            parkingBoy.fetch(null);
        });
        //then
        assertSame("Please provide your parking ticket", exception.getMessage());
    }

    @Test
    public void should_return_no_car_when_fetching_given_ticket_has_been_used() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(asList(new ParkingLot()));
        ParkingTicket parkingTicket = parkingBoy.park(car);
        parkingBoy.fetch(parkingTicket);
        //when
        RuntimeException exception = assertThrows(UnrecognizedTicketException.class, () ->{
            parkingBoy.fetch(parkingTicket);
        });
        //then
        assertSame("Unrecognized parking ticket", exception.getMessage());
    }
    
    @Test
    public void should_return_park_failed_when_parking_given_no_available_parking_lot() {
        //given
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(asList(new ParkingLot(1)));
        parkingBoy.park(firstCar);
        //when
        RuntimeException exception = assertThrows(NoAvailableSlotException.class, () -> {
            parkingBoy.park(secondCar);
        });
        //then
        assertSame("Not enough position", exception.getMessage());
    }
}
