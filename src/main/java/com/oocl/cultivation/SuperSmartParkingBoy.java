package com.oocl.cultivation;

import java.util.ArrayList;

public class SuperSmartParkingBoy {
    private ArrayList<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(ArrayList<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws NotEnoughPosition {
        ParkingLot parkingLot = parkingLots.stream()
                .max((parkinglot1, parkingLot2) ->parkinglot1.getPositionRate() >= parkingLot2.getPositionRate() ? 1:-1)
                .orElse(null);
        return parkingLot.park(car);
    }
}
