package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot{
    private final Integer capacity;
    private Map<Ticket, Car> carTicketMap;

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
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
