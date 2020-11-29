package com.oocl.cultivation.ParkingStaff;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.Exception.NotEnoughPosition;
import com.oocl.cultivation.Exception.UnrecognizedParkingTicket;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;

import java.util.ArrayList;

public class ParkingBoy {
    private ArrayList<ParkingLot> parkingLots;

    public ParkingBoy(ArrayList<ParkingLot> parkingLots){
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

    public Car fetchCar(Ticket ticket) throws UnrecognizedParkingTicket {
        for(ParkingLot parkingLot: parkingLots){
            try{
                return parkingLot.fetchCar(ticket);
            }catch (UnrecognizedParkingTicket ignoringExc){

            }
        }
        throw new UnrecognizedParkingTicket();
    }
    public ArrayList<ParkingLot> getParkingLots(){
        return this.parkingLots;
    }
}
