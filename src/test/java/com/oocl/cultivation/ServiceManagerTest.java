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


}
