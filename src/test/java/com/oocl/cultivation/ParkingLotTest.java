package com.oocl.cultivation;

import com.oocl.cultivation.Exception.NotEnoughPosition;
import com.oocl.cultivation.Exception.UnrecognizedParkingTicket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_parkingCar_given_parkingLot_with_availbale_capacity() throws NotEnoughPosition {
        //given
        ParkingLot parkinglot = new ParkingLot(1);
        Car car = new Car();

        //when
        Ticket ticket = parkinglot.park(car);

        //then
        assertNotNull(ticket);

    }

    @Test
    void should_throw_notenoughposition_exception_when_parkingCar_given_parkingLot_with_no_availabale_capacity() throws NotEnoughPosition {
        //given
        ParkingLot parkinglot = new ParkingLot(0);
        Car car = new Car();

        //when
        NotEnoughPosition notEnoughPositionException = assertThrows(NotEnoughPosition.class, () -> {
            parkinglot.park(car);
        });

        //then
        assertEquals("Not enough position.", notEnoughPositionException.getMessage());
    }

    @Test
    void should_return_multi_tickets_when_parkingCar_given_multi_cars_parkingLot_with_10_availbale_capacity() throws NotEnoughPosition {
        //given
        ParkingLot parkinglot = new ParkingLot(10);
        Car car1 = new Car();
        Car car2 = new Car();

        //when
        Ticket ticket1 = parkinglot.park(car1);
        Ticket ticket2 = parkinglot.park(car2);

        //then
        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertNotEquals(ticket1, ticket2);
    }

    @Test
    void should_return_oneTicket_and_throw_notenoughposition_exception_when_parkingCar_given_multicars_parkingLot_with_1_availbale_capacity() throws NotEnoughPosition {
        //given
        ParkingLot parkinglot = new ParkingLot(1);
        Car car1 = new Car();
        Car car2 = new Car();

        //when
        Ticket ticket1 = parkinglot.park(car1);
        NotEnoughPosition notEnoughPositionException = assertThrows(NotEnoughPosition.class, () -> {
            Ticket ticket2 = parkinglot.park(car2);
        });

        //then
        assertNotNull(ticket1);
        assertEquals("Not enough position.", notEnoughPositionException.getMessage());
    }

    @Test
    void should_return_car_when_fetchCar_given_parkinglot_that_parked_car() throws UnrecognizedParkingTicket, NotEnoughPosition {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        //when
        Car actual = parkingLot.fetchCar(ticket);

        //then
        assertEquals(car, actual);
    }

    @Test
    void should_throw_unrecognizedparkingticket_exception_when_fetchCar_given_parkinglot_car_used_ticket() throws UnrecognizedParkingTicket, NotEnoughPosition {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        parkingLot.fetchCar(ticket);

        //when
        UnrecognizedParkingTicket unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicket.class, () -> {
            Car fetchedCar = parkingLot.fetchCar(ticket);
        });


        //then
        assertEquals("Unrecognized parking ticket.", unrecognizedParkingTicketException.getLocalizedMessage());

    }

    @Test
    void should_throw_unrecognizedparkingticket_exception_when_fetchCar_given_parkinglot_car_invalid_ticket() throws UnrecognizedParkingTicket, NotEnoughPosition {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        Ticket invalidTicket = new Ticket();

        //when
        UnrecognizedParkingTicket unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicket.class, () -> {
            Car fetchedCar = parkingLot.fetchCar(invalidTicket);
        });

        //then
        assertEquals("Unrecognized parking ticket.", unrecognizedParkingTicketException.getLocalizedMessage());

    }


}
