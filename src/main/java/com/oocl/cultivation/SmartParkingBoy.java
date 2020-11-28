package com.oocl.cultivation;

import java.util.ArrayList;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) throws NotEnoughPosition {
        ParkingLot parkingLot = getParkingLots().stream()
                .max((parkinglot1, parkingLot2) -> parkinglot1.getEmptyPosition() >= parkingLot2.getEmptyPosition() ? 1 : -1)
                .orElse(null);
        return parkingLot.park(car);
    }
}
