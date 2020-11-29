package com.oocl.cultivation.Exception;

public class UnrecognizedParkingTicket extends Throwable {
    public UnrecognizedParkingTicket() {
        super("Unrecognized parking ticket.");
    }

}
