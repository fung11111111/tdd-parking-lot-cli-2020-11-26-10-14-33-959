package com.oocl.cultivation;

import com.oocl.cultivation.Exception.NotEnoughPosition;
import com.oocl.cultivation.Exception.ParkingBoyNotInList;
import com.oocl.cultivation.Exception.UnrecognizedParkingTicket;
import com.oocl.cultivation.ParkingStaff.ParkingBoy;
import com.oocl.cultivation.ParkingStaff.ParkingLotServiceManager;
import com.oocl.cultivation.ParkingStaff.SmartParkingBoy;
import com.oocl.cultivation.ParkingStaff.SuperSmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotServiceManagerTest {
    @Test
    void should_add_parkingboy_when_parkinglotservicemanager_addParkingBoy_given_parkinglotservicemanager_parkingBoy_parkinglots() {
        //given

        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(new ArrayList<ParkingBoy>(), parkingLots);

        //when
        parkingLotServiceManager.addParkingBoy(parkingBoy);
        parkingLotServiceManager.addParkingBoy(smartParkingBoy);
        parkingLotServiceManager.addParkingBoy(superSmartParkingBoy);


        //then
        assertEquals(true, parkingLotServiceManager.isParkingBoyInList(parkingBoy));
        assertEquals(true, parkingLotServiceManager.isParkingBoyInList(smartParkingBoy));
        assertEquals(true, parkingLotServiceManager.isParkingBoyInList(superSmartParkingBoy));

    }

    @Test
    void should_return_ticket_when_parkinglotservicemanager_assignparkingboypark_given_parkinglotservicemanager_parkingBoy_car_parkinglot() throws NotEnoughPosition, ParkingBoyNotInList {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(new ArrayList<ParkingBoy>(), parkingLots);
        Car car = new Car();
        parkingLotServiceManager.addParkingBoy(parkingBoy);

        //when
        Ticket ticket = parkingLotServiceManager.assignParkingBoyPark(parkingBoy, car);

        //then
        assertNotNull(ticket);

    }

    @Test
    void should_throw_parkingboynotinlist_exception_when_parkinglotservicemanager_assignparkingboypark_given_parkinglotservicemanager_incorrectparkingBoy_car_parkinglot() throws NotEnoughPosition, ParkingBoyNotInList {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(new ArrayList<ParkingBoy>(), parkingLots);
        Car car = new Car();
        parkingLotServiceManager.addParkingBoy(parkingBoy);

        //when
        ParkingBoyNotInList parkingBoyNotInListException = assertThrows(ParkingBoyNotInList.class, () -> {
            Ticket ticket = parkingLotServiceManager.assignParkingBoyPark(new ParkingBoy(parkingLots), car);
        });

        //then
        assertEquals("Parking boy not in list.", parkingBoyNotInListException.getLocalizedMessage());

    }


    @Test
    void should_throw_notenoughposition_exception_when_parkinglotservicemanager_assignparkingboypark_given_parkinglotservicemanager_parkingboy_car_parkingLot_with_no_available_capacity() throws NotEnoughPosition {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(0));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(new ArrayList<ParkingBoy>(), parkingLots);
        Car car = new Car();
        parkingLotServiceManager.addParkingBoy(parkingBoy);

        //when
        NotEnoughPosition notEnoughPositionException = assertThrows(NotEnoughPosition.class, () -> {
            Ticket ticket = parkingLotServiceManager.assignParkingBoyPark(parkingBoy, car);
        });

        //then
        assertEquals("Not enough position.", notEnoughPositionException.getMessage());

    }

    @Test
    void should_return_car_when_parkinglotservicemanager_assignparkingboyfetch_given_parkinglotservicemanager_parkingBoy_ticket() throws NotEnoughPosition, UnrecognizedParkingTicket, ParkingBoyNotInList {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(new ArrayList<ParkingBoy>(), parkingLots);
        parkingLotServiceManager.addParkingBoy(parkingBoy);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);

        //when
        Car fetchedCar = parkingLotServiceManager.assignParkingBoyFetch(parkingBoy, ticket);

        //then
        assertNotNull(fetchedCar);
        assertEquals(car, fetchedCar);

    }

    @Test
    void should_throw_throw_unrecognizedparkingticket_exception_when_parkinglotservicemanager_assignparkingboyfetch_given_parkinglotservicemanager_parkingBoy_usedticket() throws NotEnoughPosition, UnrecognizedParkingTicket {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(new ArrayList<ParkingBoy>(), parkingLots);
        parkingLotServiceManager.addParkingBoy(parkingBoy);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        parkingBoy.fetchCar(ticket);

        //when
        UnrecognizedParkingTicket unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicket.class, () -> {
            Car fetchedCar = parkingLotServiceManager.assignParkingBoyFetch(parkingBoy, ticket);
        });


        //then
        assertEquals("Unrecognized parking ticket.", unrecognizedParkingTicketException.getLocalizedMessage());

    }

    @Test
    void should_throw_throw_unrecognizedparkingticket_exception_when_parkinglotservicemanager_assignparkingboyfetch_given_parkinglotservicemanager_parkingBoy_invalidticket() throws NotEnoughPosition, UnrecognizedParkingTicket {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(new ArrayList<ParkingBoy>(), parkingLots);
        parkingLotServiceManager.addParkingBoy(parkingBoy);
        Car car = new Car();
        parkingBoy.park(car);

        //when
        UnrecognizedParkingTicket unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicket.class, () -> {
            Car fetchedCar = parkingLotServiceManager.assignParkingBoyFetch(parkingBoy, new Ticket());
        });


        //then
        assertEquals("Unrecognized parking ticket.", unrecognizedParkingTicketException.getLocalizedMessage());

    }

    @Test
    void should_return_ticket_when_parkinglotservicemanager_park_given_parkinglotservicemanager_car_parkinglots_with_available_capacity() throws NotEnoughPosition {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(1));
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(new ArrayList<ParkingBoy>(), parkingLots);

        //when
        Ticket ticket = parkingLotServiceManager.park(new Car());

        //then
        assertNotNull(ticket);

    }

    @Test
    void should_return_ticket_when_parkinglotservicemanager_park_given_parkinglotservicemanager_multicars_parkinglot1_with_no_available_capacity() throws NotEnoughPosition {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(1));
        parkingLots.add(new ParkingLot(1));
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(new ArrayList<ParkingBoy>(), parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();

        //when
        Ticket ticket1 = parkingLotServiceManager.park(car1);
        Ticket ticket2 = parkingLotServiceManager.park(car2);


        //then
        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertNotEquals(ticket1, ticket2);

    }

    @Test
    void should_return_car_when_parkinglotservicemanager_fetchcar_given_parkinglotservicemanager_ticket_parkinglot_that_parked_car() throws NotEnoughPosition, UnrecognizedParkingTicket {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLots.add(parkingLot);
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(new ArrayList<ParkingBoy>(), parkingLots);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        //when
        Car fetchCarcar = parkingLotServiceManager.fetchCar(ticket);


        //then
        assertNotNull(fetchCarcar);

    }

    @Test
    void should_throw_parkingboynotinlist_exception_when_parkinglotservicemanager_assignparkingboyfetch_given_parkinglotservicemanager_incorrectparkingBoy_ticket() throws NotEnoughPosition, ParkingBoyNotInList {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(new ArrayList<ParkingBoy>(), parkingLots);
        Car car = new Car();
        parkingLotServiceManager.addParkingBoy(parkingBoy);
        Ticket ticker = parkingBoy.park(car);

        //when
        ParkingBoyNotInList parkingBoyNotInListException = assertThrows(ParkingBoyNotInList.class, () -> {
            Car fetchedCar = parkingLotServiceManager.assignParkingBoyFetch(new ParkingBoy(parkingLots), ticker);
        });

        //then
        assertEquals("Parking boy not in list.", parkingBoyNotInListException.getLocalizedMessage());

    }


}
