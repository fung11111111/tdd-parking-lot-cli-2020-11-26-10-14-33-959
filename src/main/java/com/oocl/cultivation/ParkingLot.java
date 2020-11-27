package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot{

    private final Integer capacity;
    private ArrayList<Car> cars;

    private Map<Ticket, Car> carTicketMap;

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
        cars = new ArrayList<>();
        carTicketMap = new HashMap<>();
    }
    public Boolean isavailbale(){
        return carTicketMap.size() < capacity;
    }

    public Ticket park(Car car) {
        if(!isavailbale()){
            return null;
        }
        Ticket ticket = new Ticket();
        carTicketMap.put(ticket,car);
        return ticket;
    }

    public Car fetchCar(Ticket ticket) {
        Car car = null;
        if(carTicketMap.containsKey(ticket)){
            car = carTicketMap.get(ticket);
            carTicketMap.remove(ticket);
        }

        return car;
    }
}
