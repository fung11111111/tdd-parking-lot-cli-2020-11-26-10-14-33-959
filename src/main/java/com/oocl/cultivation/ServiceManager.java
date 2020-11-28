package com.oocl.cultivation;

import java.util.ArrayList;

public class ServiceManager {
    ArrayList<ParkingBoy> managementList;
    ArrayList<ParkingLot> parkingLots;

    public ServiceManager(ArrayList<ParkingBoy> managementList, ArrayList<ParkingLot> parkingLots) {
        this.managementList = managementList;
        this.parkingLots = parkingLots;
    }

    public void addParkingBoy(ParkingBoy parkingBoy) {
        this.managementList.add(parkingBoy);
    }

    public Ticket parkWithParkingBoy(ParkingBoy parkingBoy) {
        return null;
    }

    public Boolean isParkingBoyInList(ParkingBoy parkingBoy) {
        if (managementList.contains(parkingBoy)) {
            return true;
        }
        return false;
    }

    public Ticket assignParkingBoyPark(ParkingBoy parkingBoy,Car car) throws NotEnoughPosition, ParkingBoyNotInList{
        if (isParkingBoyInList(parkingBoy)){
            return parkingBoy.park(car);
        }
        throw new ParkingBoyNotInList();
    }

    public Car assignParkingBoyFetch(ParkingBoy parkingBoy, Ticket ticket) throws UnrecognizedParkingTicket, ParkingBoyNotInList {
        if (isParkingBoyInList(parkingBoy)){
            return parkingBoy.fetchCar(ticket);
        }
        throw new ParkingBoyNotInList();
    }

    public Ticket park(Car car) throws NotEnoughPosition {
        for(ParkingLot parkingLot: parkingLots){
            try{
                return parkingLot.park(car);
            }catch (NotEnoughPosition ignoringExc){

            }
        }
        throw new NotEnoughPosition();
    }

    public Car fetchCar(Ticket ticket) throws UnrecognizedParkingTicket {
        for(ParkingLot parkingLot: parkingLots){
            try{
                return parkingLot.fetchCar(ticket);
            }catch (UnrecognizedParkingTicket ignoringExc){

            }
        }
        throw new UnrecognizedParkingTicket();
    }
}
