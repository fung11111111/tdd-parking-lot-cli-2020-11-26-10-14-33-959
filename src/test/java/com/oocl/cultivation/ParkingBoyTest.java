package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ParkingBoyTest {

    @Test
    void should_return_ticket_when_parkingCar_given_parkingBoy_parkingLot_with_availbale_capacity() {
        //given 
        ParkingLot parkinglot = Mockito.mock(ParkingLot.class);
        ParkingBoy parkingBoy = new ParkingBoy(parkinglot);
        Car car = new Car();
        
        //when 
        parkingBoy.park(car);

        //then
        verify(parkinglot, times(1)).park(car);
        
    }



}
