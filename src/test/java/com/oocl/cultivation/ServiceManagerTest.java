package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceManagerTest {
    @Test
    void should_add_parkingboy_when_servicemanager_addParkingBoy_given_servicemanager_parkingBoy_parkinglots() {
        //given

        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        ServiceManager serviceManager = new ServiceManager(new ArrayList<ParkingBoy>(), parkingLots);

        //when
        serviceManager.addParkingBoy(parkingBoy);
        serviceManager.addParkingBoy(smartParkingBoy);
        serviceManager.addParkingBoy(superSmartParkingBoy);


        //then
        assertEquals(true, serviceManager.isParkingBoyInList(parkingBoy));
        assertEquals(true, serviceManager.isParkingBoyInList(smartParkingBoy));
        assertEquals(true, serviceManager.isParkingBoyInList(superSmartParkingBoy));

    }

    @Test
    void should_return_ticket_when_servicemanager_assignparkingboypark_given_servicemanager_parkingBoy_car_parkinglot() throws NotEnoughPosition {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ServiceManager serviceManager = new ServiceManager(new ArrayList<ParkingBoy>(), parkingLots);
        Car car = new Car();
        serviceManager.addParkingBoy(parkingBoy);

        //when
        Ticket ticket = serviceManager.assignParkingBoyPark(parkingBoy, car);

        //then
        assertNotNull(ticket);

    }

    @Test
    void should_throw_notenoughposition_exception_when_servicemanager_assignparkingboypark_given_servicemanager_parkingboy_car_parkingLot_with_no_available_capacity() throws NotEnoughPosition {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(0));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ServiceManager serviceManager = new ServiceManager(new ArrayList<ParkingBoy>(), parkingLots);
        Car car = new Car();
        serviceManager.addParkingBoy(parkingBoy);

        //when
        NotEnoughPosition notEnoughPositionException = assertThrows(NotEnoughPosition.class, () -> {
            Ticket ticket = serviceManager.assignParkingBoyPark(parkingBoy,car);
        });

        //then
        assertEquals("Not enough position.", notEnoughPositionException.getMessage());

    }

    @Test
    void should_return_car_when_servicemanager_assignparkingboyfetch_given_servicemanager_parkingBoy_ticket() throws NotEnoughPosition, UnrecognizedParkingTicket {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ServiceManager serviceManager = new ServiceManager(new ArrayList<ParkingBoy>(), parkingLots);
        serviceManager.addParkingBoy(parkingBoy);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);

        //when
        Car fetchedCar = serviceManager.assignParkingBoyFetch(parkingBoy,ticket);

        //then
        assertNotNull(fetchedCar);
        assertEquals(car, fetchedCar);

    }


}
