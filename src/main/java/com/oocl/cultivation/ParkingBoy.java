package com.oocl.cultivation;

public class ParkingBoy {
    private ParkingLot parkingLot;
    public ParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }
    public Ticket park(Car car) throws NotEnoughPosition{
        return this.parkingLot.park(car);
    }

    public Car fetchCar(Ticket ticket) throws UnrecognizedParkingTicket{
        return this.parkingLot.fetchCar(ticket);
    }
}
