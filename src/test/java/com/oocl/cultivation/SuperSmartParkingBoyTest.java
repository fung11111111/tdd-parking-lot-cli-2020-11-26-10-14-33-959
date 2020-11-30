package com.oocl.cultivation;

import com.oocl.cultivation.Exception.NotEnoughPosition;
import com.oocl.cultivation.ParkingStaff.SuperSmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SuperSmartParkingBoyTest {

    @Test
    void should_return_ticket_from_parkinglot1_when_supersmartparkingboy_park_given_supersmartparkingboy_car_multiparkingLots_with_parkinglot1_has_larger_position_rate() throws NotEnoughPosition {
        //given
        ParkingLot parkinglot1 = new ParkingLot(2);
        ParkingLot parkinglot2 = new ParkingLot(3);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkinglot1);
        parkingLots.add(parkinglot2);
        parkinglot1.park(new Car());
        parkinglot2.park(new Car());
        parkinglot2.park(new Car());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car();

        //when
        Ticket ticket = superSmartParkingBoy.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_throw_notenoughposition_exception_when_supersmartparkingboy_park_given_supersmartparkingboy_car_multiparkingLots_with_no_available_capacity() throws NotEnoughPosition {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(0));
        parkingLots.add(new ParkingLot(0));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car();

        //when
        NotEnoughPosition notEnoughPositionException = assertThrows(NotEnoughPosition.class, () -> {
            Ticket ticket = superSmartParkingBoy.park(car);
        });

        //then
        assertEquals("Not enough position.", notEnoughPositionException.getMessage());
    }


}
