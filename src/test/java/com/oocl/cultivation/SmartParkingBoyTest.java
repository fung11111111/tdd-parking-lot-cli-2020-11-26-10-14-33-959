package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.spy;

public class SmartParkingBoyTest {
    @Test
    void should_return_ticket_from_parkinglot2_when_smartparkingboy_park_given_smartparkingboy_car_parkingLot2_with_more_capacity() throws NotEnoughPosition {
        //given
        ParkingLot parkinglot1 = new ParkingLot(4);
        ParkingLot parkinglot2 = new ParkingLot(10);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkinglot1);
        parkingLots.add(parkinglot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();

        //when
        Ticket ticket = smartParkingBoy.park(car);

        //then
        assertNotNull(ticket);
        assertEquals(parkinglot2,ticket.getParkingLot());

    }

    @Test
    void should_throw_notenoughposition_exception_when_smartparkingboy_park_given_smartparkingboy_car_parkingLots_with_no_available_capacity() throws NotEnoughPosition {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(0));
        parkingLots.add(new ParkingLot(0));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();

        //when
        NotEnoughPosition notEnoughPositionException = assertThrows(NotEnoughPosition.class, () -> {
            Ticket ticket = smartParkingBoy.park(car);
        });

        //then
        assertEquals("Not enough position.", notEnoughPositionException.getMessage());

    }
}
