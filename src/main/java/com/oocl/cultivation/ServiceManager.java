package com.oocl.cultivation;

import java.util.ArrayList;

public class ServiceManager {
    ArrayList<ParkingBoy> managementList;
    ArrayList<ParkingLot> parkingLots;

    public ServiceManager(ArrayList<ParkingBoy> managementList, ArrayList<ParkingLot> parkingLots) {
        this.managementList = managementList;
        this.parkingLots = parkingLots;
    }

    public void addParkingBoy(ParkingBoy parkingBoy) {
        this.managementList.add(parkingBoy);
    }

    public Ticket parkWithParkingBoy(ParkingBoy parkingBoy) {
        return null;
    }

    public Boolean isParkingBoyInList(ParkingBoy parkingBoy) {
        if (managementList.contains(parkingBoy)) {
            return true;
        }
        return false;
    }

    public Ticket assignParkingBoyPark(ParkingBoy parkingBoy,Car car) throws NotEnoughPosition {
        if (isParkingBoyInList(parkingBoy)){
            return parkingBoy.park(car);
        }
        return null;
    }
}
