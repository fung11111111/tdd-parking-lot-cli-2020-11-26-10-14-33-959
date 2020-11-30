package com.oocl.cultivation.ParkingStaff;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.Exception.NotEnoughPosition;
import com.oocl.cultivation.Exception.ParkingBoyNotInList;
import com.oocl.cultivation.Exception.UnrecognizedParkingTicket;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;

import java.util.ArrayList;

public class ParkingLotServiceManager extends ParkingBoy {
    ArrayList<ParkingBoy> managementList;

    public ParkingLotServiceManager(ArrayList<ParkingBoy> managementList, ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
        this.managementList = managementList;
    }

    public void addParkingBoy(ParkingBoy parkingBoy) {
        this.managementList.add(parkingBoy);
    }

    public Boolean isParkingBoyInList(ParkingBoy parkingBoy) {
        return managementList.contains(parkingBoy);
    }

    // not need passing parkingboy
    public Ticket assignParkingBoyPark(ParkingBoy parkingBoy, Car car) throws NotEnoughPosition, ParkingBoyNotInList {
        if (isParkingBoyInList(parkingBoy)) {
            return parkingBoy.park(car);
        }
        throw new ParkingBoyNotInList();
    }

    // not need passing parkingboy
    public Car assignParkingBoyFetch(ParkingBoy parkingBoy, Ticket ticket) throws UnrecognizedParkingTicket, ParkingBoyNotInList {
        if (isParkingBoyInList(parkingBoy)) {
            return parkingBoy.fetchCar(ticket);
        }
        throw new ParkingBoyNotInList();
    }

}
