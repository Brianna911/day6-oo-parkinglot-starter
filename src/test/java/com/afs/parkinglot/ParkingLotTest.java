package com.afs.parkinglot;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {

    @Test
    public void testParkCarAndGetTicket() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car("ABC123");
        Ticket ticket = parkingLot.park(car);
        assertNotNull(ticket);
    }
    @Test
    public void testFetchCarWithValidTicket() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car("ABC123");
        Ticket ticket;
        ticket = parkingLot.park(car);
        Car fetchedCar = parkingLot.fetch(ticket);
        assertNotNull(fetchedCar);
        assertEquals(car, fetchedCar);
    }
}
