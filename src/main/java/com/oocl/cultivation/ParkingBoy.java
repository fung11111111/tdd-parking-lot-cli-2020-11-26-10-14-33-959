package com.oocl.cultivation;

public class ParkingBoy {
    private ParkingLot parkinglot;
    private Car car;
    public ParkingBoy(ParkingLot parkinglot) {
        this.parkinglot = parkinglot;
    }
    public Ticket park(Car car){
        return parkinglot.park(car);
    }
}
