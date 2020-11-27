package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Arrays;

public class ParkingLot{

    private final Integer capacity;
    private ArrayList<Car> cars;

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
        cars = new ArrayList<>();
    }

    public Ticket park(Car car) {
        if(capacity - cars.size() <= 0){
            return null;
        }
        return new Ticket();
    }
}
