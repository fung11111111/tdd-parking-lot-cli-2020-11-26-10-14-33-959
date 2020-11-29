package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingLotServiceManager extends ParkingBoy{
    ArrayList<ParkingBoy> managementList;

    public ParkingLotServiceManager(ArrayList<ParkingBoy> managementList, ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
        this.managementList = managementList;
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

    public Ticket assignParkingBoyPark(ParkingBoy parkingBoy,Car car) throws NotEnoughPosition, ParkingBoyNotInList{
        if (isParkingBoyInList(parkingBoy)){
            return parkingBoy.park(car);
        }
        throw new ParkingBoyNotInList();
    }

    public Car assignParkingBoyFetch(ParkingBoy parkingBoy, Ticket ticket) throws UnrecognizedParkingTicket, ParkingBoyNotInList {
        if (isParkingBoyInList(parkingBoy)){
            return parkingBoy.fetchCar(ticket);
        }
        throw new ParkingBoyNotInList();
    }

}
