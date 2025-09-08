package com.afs.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket, Car> parkedCars = new HashMap<>();

    public ParkingLot(int capacity) {
    }

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        parkedCars.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        return parkedCars.get(ticket);
    }
}