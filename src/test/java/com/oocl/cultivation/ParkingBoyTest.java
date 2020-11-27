package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

class ParkingBoyTest {

    @Test
    void should_call_park_when_parkingboy_park_given_parkingBoy_car_parkingLot_with_availbale_capacity() {
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
    void should_call_fetchCar_when_parkingboy_fetchcar_given_parkingBoy_ticket_parkinglot_that_parked_car() {
        //given
        ParkingLot parkingLot = Mockito.mock(ParkingLot.class);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        parkingBoy.fetchCar(ticket);

        //then
        verify(parkingLot, times(1)).park(car);
    }




}
