package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_parkingCar_given_parkingBoy_parkingLot_with_availbale_capacity() {
        //given
        ParkingLot parkinglot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkinglot);
        Car car = new Car();

        //when
        Ticket ticket = parkingBoy.park(car);

        //then
        assertNotNull(ticket);

    }

    @Test
    void should_return_noticket_when_parkingCar_given_parkingBoy_parkingLot_with_no_availbale_capacity() {
        //given
        ParkingLot parkinglot = new ParkingLot(0);
        ParkingBoy parkingBoy = new ParkingBoy(parkinglot);
        Car car = new Car();

        //when
        Ticket ticket = parkingBoy.park(car);

        //then
        assertNull(ticket);
    }

    @Test
    void should_return_ticket_when_parkingCar_given_multicars_parkingBoy_parkingLot_with_availbale_capacity() {
        //given
        ParkingLot parkinglot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkinglot);
        Car car1 = new Car();
        Car car2 = new Car();

        //when
        Ticket ticket1 = parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);

        //then
        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertNotEquals(ticket1,ticket2);
    }

}
