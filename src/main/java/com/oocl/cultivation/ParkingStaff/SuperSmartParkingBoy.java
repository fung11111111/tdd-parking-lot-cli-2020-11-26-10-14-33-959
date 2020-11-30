package com.oocl.cultivation.ParkingStaff;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.Exception.NotEnoughPosition;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingStaff.ParkingBoy;
import com.oocl.cultivation.Ticket;

import java.util.ArrayList;
import java.util.Comparator;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    // edit as smartparkingboy
    @Override
    public Ticket park(Car car) throws NotEnoughPosition {
        return getParkingLots().stream()
                .filter(parkingLot -> parkingLot.getEmptyPosition() > 0)
                .max(Comparator.comparing(ParkingLot::getPositionRate))
                .orElseThrow(() -> new NotEnoughPosition())
                .park(car);
    }
}
