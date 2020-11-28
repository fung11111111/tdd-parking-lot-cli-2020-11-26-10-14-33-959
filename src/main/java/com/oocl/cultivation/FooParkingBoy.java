package com.oocl.cultivation;

import java.util.ArrayList;

public class FooParkingBoy {
    private  ArrayList<ParkingLot> parkingLots;
    public FooParkingBoy(ArrayList<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws NotEnoughPosition {
       for(ParkingLot parkingLot: parkingLots){
           try{
               return parkingLot.park(car);
           }catch (NotEnoughPosition ignoringExc){

           }
       }
       throw new NotEnoughPosition();

    }
}
