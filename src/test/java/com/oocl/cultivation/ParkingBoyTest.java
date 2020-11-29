package com.oocl.cultivation;

import com.oocl.cultivation.Exception.NotEnoughPosition;
import com.oocl.cultivation.Exception.UnrecognizedParkingTicket;
import com.oocl.cultivation.ParkingStaff.ParkingBoy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.spy;

class ParkingBoyTest {

    @Test
    void should_call_park_when_parkingboy_park_given_parkingBoy_car_parkingLot_with_availbale_capacity() throws NotEnoughPosition {
        //given
        ParkingLot parkingLot = Mockito.mock(ParkingLot.class);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();

        //when
        parkingBoy.park(car);

        //then
        verify(parkingLot, times(1)).park(car);
    }


    @Test
    void should_call_fetchCar_when_parkingboy_fetchcar_given_parkingBoy_ticket_parkinglot_that_parked_car() throws UnrecognizedParkingTicket, NotEnoughPosition {
        //given
        ParkingLot parkingLot = Mockito.mock(ParkingLot.class);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        //when
        parkingBoy.fetchCar(ticket);

        //then
        verify(parkingLot, times(1)).park(car);
    }

    @Test
    void should_parkingLot1_call_park_when_parkingboy_park_given_parkingBoy_car_parkingLot1_with_availbale_capacity() throws NotEnoughPosition {
        //given
        ParkingLot parkingLot1 = spy(new ParkingLot(1));
        ParkingLot parkingLot2 = Mockito.mock(ParkingLot.class);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();

        //when
        parkingBoy.park(car);

        //then
        verify(parkingLot1, times(1)).park(car);
        verify(parkingLot2, times(0)).park(car);
    }

    @Test
    void should_parkingLot2_call_park_when_parkingboy_park_given_parkingBoy_multi_cars_parkingLot1_with_no_availbale_capacity() throws NotEnoughPosition {
        //given
        ParkingLot parkingLot1 = spy(new ParkingLot(0));
        ParkingLot parkingLot2 = Mockito.mock(ParkingLot.class);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();

        //when
        parkingBoy.park(car);

        //then
        verify(parkingLot1, times(1)).park(car);
        verify(parkingLot2, times(1)).park(car);
    }

    @Test
    void should_return_ticket_from_parkingLot1_when_parkingboy_park_given_parkingboy_multicas_two_parkingLots_with_availbale_capacity() throws NotEnoughPosition {
        //given
        ParkingLot parkinglot1 = new ParkingLot(10);
        ParkingLot parkinglot2 = new ParkingLot(10);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkinglot1);
        parkingLots.add(parkinglot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();

        //when
        Ticket ticket1 = parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);

        //then
        assertNotNull(ticket1);
        assertNotNull(ticket2);


    }

    @Test
    void should_return_ticket_from_parkingLot2_when_parkingboy_park_given_parkingboy_car_parkingLot1_with_no_capacity() throws NotEnoughPosition {
        //given
        ParkingLot parkinglot1 = new ParkingLot(1);
        ParkingLot parkinglot2 = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkinglot1);
        parkingLots.add(parkinglot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();

        //when
        Ticket parkinglot1Ticket = parkingBoy.park(new Car());
        Ticket ticket = parkingBoy.park(car);

        //then
        assertNotNull(ticket);
        assertNotEquals(parkinglot1Ticket, ticket);

    }

    @Test
    void should_throw_notenoughposition_exception_when_parkingboy_park_given_parkingboy_car_parkingLots_with_no_capacity() throws NotEnoughPosition {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(0));
        parkingLots.add(new ParkingLot(0));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();

        //when
        NotEnoughPosition notEnoughPositionException = assertThrows(NotEnoughPosition.class, () -> {
            Ticket ticket = parkingBoy.park(car);
        });

        //then
        assertEquals("Not enough position.", notEnoughPositionException.getMessage());

    }

    @Test
    void should_return_car_when_fetchCar_given_parkingboy_ticket_from_one_of_parkinglots() throws UnrecognizedParkingTicket, NotEnoughPosition {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        parkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Ticket ticket = parkingBoy.park(new Car());

        //when
        Car car = parkingBoy.fetchCar(ticket);

        //then
        assertNotNull(car);
    }

    @Test
    void should_throw_unrecognizedparkingticket_exception_when_fetchCar_given_parkingboy_multiparkinglots_car_used_ticket() throws UnrecognizedParkingTicket, NotEnoughPosition {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        parkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Ticket ticket = parkingBoy.park(new Car());
        parkingBoy.fetchCar(ticket);

        //when
        UnrecognizedParkingTicket unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicket.class, () -> {
            Car fetchedCar = parkingBoy.fetchCar(ticket);
        });


        //then
        assertEquals("Unrecognized parking ticket.", unrecognizedParkingTicketException.getLocalizedMessage());

    }

    @Test
    void should_throw_unrecognizedparkingticket_exception_when_fetchCar_given_parkingboy_multiparkinglots_invalid_ticket() throws UnrecognizedParkingTicket, NotEnoughPosition {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        parkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Ticket invalidTicket = new Ticket();

        //when
        UnrecognizedParkingTicket unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicket.class, () -> {
            Car fetchedCar = parkingBoy.fetchCar(invalidTicket);
        });


        //then
        assertEquals("Unrecognized parking ticket.", unrecognizedParkingTicketException.getLocalizedMessage());

    }


}
