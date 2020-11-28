package com.oocl.cultivation;

import java.util.ArrayList;

public class ServiceManager {
    ArrayList<ParkingBoy> managementList;
    ArrayList<ParkingLot> parkingLots;
    public ServiceManager(ArrayList<ParkingBoy> managementList, ArrayList<ParkingLot> parkingLots) {
        this.managementList = managementList;
        this.parkingLots = parkingLots;
    }

    public void addParkingBoy(ParkingBoy parkingBoy){
        this.managementList.add(parkingBoy);
    }
    public Ticket parkWithParkingBoy(ParkingBoy parkingBoy){
        return null;
    }


    public ParkingBoy getParkingBoy(ParkingBoy parkingBoy) {
        return null;
    }
}
