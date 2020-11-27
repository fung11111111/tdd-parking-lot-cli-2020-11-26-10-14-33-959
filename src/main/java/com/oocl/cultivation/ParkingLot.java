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
        cars.add(car);
        return new Ticket();
    }

    public Car fetchCar(Ticket ticket) {
        return new Car();
    }
}
