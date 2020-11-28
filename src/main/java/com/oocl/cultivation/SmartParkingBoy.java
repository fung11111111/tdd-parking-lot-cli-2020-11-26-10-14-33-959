package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Comparator;

public class SmartParkingBoy {
    private ArrayList<ParkingLot> parkingLots;

    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws NotEnoughPosition {
        ParkingLot parkingLot = parkingLots.stream()
                .max((parkinglot1, parkingLot2) ->parkinglot1.getEmptyPosition() >= parkingLot2.getEmptyPosition() ? 1:-1)
                .orElse(null);
        return parkingLot.park(car);
    }
}
