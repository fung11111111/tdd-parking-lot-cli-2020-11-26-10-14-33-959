package com.oocl.cultivation;

import java.util.ArrayList;

public class FooParkingBoy {
    private  ArrayList<ParkingLot> parkingLots;
    public FooParkingBoy(ArrayList<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }

    public void park(Car car) throws NotEnoughPosition {
        for (ParkingLot parkingLot: parkingLots){
            Ticket ticket = parkingLot.park(car);
            if(ticket != null){
                break;
            }
        }
    }
}
