package com.oocl.cultivation;

import java.util.ArrayList;

public class FooParkingBoy {
    private  ArrayList<ParkingLot> parkingLots;
    public FooParkingBoy(ArrayList<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws NotEnoughPosition {
        try {
            for (ParkingLot parkingLot: parkingLots){
                Ticket ticket = parkingLot.park(car);
                if(ticket != null){
                    return ticket;
                }
            }
        }catch (NotEnoughPosition ignoringExc){
        }

        return null;
    }
}
