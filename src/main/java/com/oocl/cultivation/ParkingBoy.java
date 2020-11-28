package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingBoy {
    private ParkingLot parkingLot;
    private ArrayList<ParkingLot> parkingLots;

    public ParkingBoy(ArrayList<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }
    public Ticket park(Car car) throws NotEnoughPosition{
        for(ParkingLot parkingLot: parkingLots){
            try{
                return parkingLot.park(car);
            }catch (NotEnoughPosition ignoringExc){

            }
        }
        throw new NotEnoughPosition();
    }

    public Car fetchCar(Ticket ticket) throws UnrecognizedParkingTicket{
        return this.parkingLot.fetchCar(ticket);
    }
}
