package com.afs.parkinglot;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {

    @Test
    public void testParkCarAndGetTicket() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car("ABC123");
        Ticket ticket = parkingLot.park(car);
        assertNotNull(ticket);
    }
}
