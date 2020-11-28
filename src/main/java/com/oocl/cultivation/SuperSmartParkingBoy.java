package com.oocl.cultivation;

import java.util.ArrayList;

public class SuperSmartParkingBoy extends ParkingBoy{

    public SuperSmartParkingBoy(ArrayList<ParkingLot> parkingLots){
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) throws NotEnoughPosition {
        ParkingLot parkingLot = getParkingLots().stream()
                .max((parkinglot1, parkingLot2) ->parkinglot1.getPositionRate() >= parkingLot2.getPositionRate() ? 1:-1)
                .orElse(null);
        return parkingLot.park(car);
    }
}
