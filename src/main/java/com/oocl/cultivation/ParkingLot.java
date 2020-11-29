package com.oocl.cultivation;

import com.oocl.cultivation.Exception.NotEnoughPosition;
import com.oocl.cultivation.Exception.UnrecognizedParkingTicket;

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

    public Ticket park(Car car) throws NotEnoughPosition {
        if(!isavailbale()){
            throw new NotEnoughPosition();
        }
        Ticket ticket = new Ticket();
        carTicketMap.put(ticket,car);
        return ticket;
    }

    public Car fetchCar(Ticket ticket) throws UnrecognizedParkingTicket {
        Car car = null;
        if(carTicketMap.containsKey(ticket)){
            car = carTicketMap.get(ticket);
            carTicketMap.remove(ticket);
            return car;
        }

       throw new UnrecognizedParkingTicket();
    }
    public int getEmptyPosition(){
        return this.capacity - carTicketMap.size();
    }
    public double getPositionRate(){
        return Double.valueOf(getEmptyPosition()) / Double.valueOf(capacity);
    }
}
