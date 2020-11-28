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
        assertEquals(parkingBoy, serviceManager.getParkingBoy(parkingBoy));
        assertEquals(smartParkingBoy, serviceManager.getParkingBoy(smartParkingBoy));
        assertEquals(superSmartParkingBoy, serviceManager.getParkingBoy(superSmartParkingBoy));



    }


}
