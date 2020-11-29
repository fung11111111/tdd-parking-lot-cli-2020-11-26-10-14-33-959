package com.oocl.cultivation.ParkingStaff;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.Exception.NotEnoughPosition;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingStaff.ParkingBoy;
import com.oocl.cultivation.Ticket;

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
