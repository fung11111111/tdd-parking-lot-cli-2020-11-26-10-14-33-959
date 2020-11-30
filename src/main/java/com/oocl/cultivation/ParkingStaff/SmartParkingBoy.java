package com.oocl.cultivation.ParkingStaff;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.Exception.NotEnoughPosition;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;

import java.util.ArrayList;
import java.util.Comparator;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) throws NotEnoughPosition {
        return getParkingLots().stream()
                .filter(parkingLot -> parkingLot.getEmptyPosition() > 0)
                .max(Comparator.comparing(ParkingLot::getEmptyPosition))
                .orElseThrow(() -> new NotEnoughPosition())
                .park(car);
    }
}
