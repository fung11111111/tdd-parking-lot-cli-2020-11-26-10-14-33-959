package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

class ParkingBoyTest {

    @Test
    void should_verfiy_park_when_park_given_parkingBoy_parkingLot_with_availbale_capacity() {
        //given
        ParkingLot parkingLot = Mockito.mock(ParkingLot.class);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //when
        parkingBoy.park(car);

        //then
        verify(parkingLot, times(1)).park(car);
    }


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
    }



}
