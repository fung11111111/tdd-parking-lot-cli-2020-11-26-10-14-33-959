package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingBoy {
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
        for(ParkingLot parkingLot: parkingLots){
            try{
                return parkingLot.fetchCar(ticket);
            }catch (UnrecognizedParkingTicket ignoringExc){

            }
        }
        throw new UnrecognizedParkingTicket();
    }
}
