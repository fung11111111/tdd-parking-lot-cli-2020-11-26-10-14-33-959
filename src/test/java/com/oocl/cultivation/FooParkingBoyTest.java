package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class FooParkingBoyTest {
    @Test
    void should_call_park_when_parkingboy_park_given_parkingBoy_car_parkingLot1_with_availbale_capacity() throws NotEnoughPosition{
        //given
        ParkingLot parkingLot1 = Mockito.mock(ParkingLot.class);
        ParkingLot parkingLot2 = Mockito.mock(ParkingLot.class);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>(){
            {
                add(parkingLot1);
               // add(parkingLot2);
            }
        };
        FooParkingBoy fooParkingBoy = new FooParkingBoy(parkingLots);
        Car car = new Car();

        //when
        fooParkingBoy.park(car);

        //then
        verify(parkingLot1, times(1)).park(car);
        verify(parkingLot2, times(0)).park(car);
    }
}
