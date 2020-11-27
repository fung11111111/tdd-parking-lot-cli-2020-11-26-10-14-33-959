package com.oocl.cultivation;

public class UnrecognizedParkingTicket extends Throwable{
    public UnrecognizedParkingTicket(){
        super("Unrecognized parking ticket.");
    }

}
