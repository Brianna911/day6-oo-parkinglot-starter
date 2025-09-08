package com.afs.parkinglot;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    @Test
    public void testFetchTwoCarsWithTwoTickets() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car1 = new Car("CAR001");
        Car car2 = new Car("CAR002");

        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);

        Car fetchedCar1 = parkingLot.fetch(ticket1);
        Car fetchedCar2 = parkingLot.fetch(ticket2);

        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);
    }
    @Test
    public void testFetchCarWithoutTicket() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car("ABC123");
        parkingLot.park(car);
        Car fetchedCar = parkingLot.fetch(null);
        assertNull(fetchedCar);
    }
    @Test
    public void testFetchCarWithUsedTicket() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car("ABC123");
        Ticket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket); // 第一次取车
        Car fetchedCar = parkingLot.fetch(ticket); // 第二次用同一张票取车
        assertNull(fetchedCar);
    }
}
