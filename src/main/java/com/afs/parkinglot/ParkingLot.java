package com.afs.parkinglot;

import java.util.HashMap;
import java.util.Map;

//public class ParkingLot {
//    private final int capacity;
//    private Map<Ticket, Car> parkedCars = new HashMap<>();
//
//    public ParkingLot(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public Ticket park(Car car) {
//        if (parkedCars.size() >= capacity) {
//            return null;
//        }
//        Ticket ticket = new Ticket();
//        parkedCars.put(ticket, car);
//        return ticket;
//    }
//
//    public Car fetch(Ticket ticket) {
//        if (ticket == null) {
//            return null;
//        }
//        return parkedCars.remove(ticket);
//    }
//}
import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private final Map<Ticket, Car> parkedCars;
    private String lastErrorMessage;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkedCars = new HashMap<>();
        this.lastErrorMessage = "";
    }

    public Ticket park(Car car) {
        if (car == null) {
            lastErrorMessage = "车辆不能为空";
            return null;
        }

        if (parkedCars.size() >= capacity) {
            lastErrorMessage = "没有可用位置";
            return null;
        }

        Ticket ticket = new Ticket();
        parkedCars.put(ticket, car);
        lastErrorMessage = "";
        return ticket;
    }
    public Car fetch(Ticket ticket) {
    if (ticket == null) {
        return null;
    }
    return parkedCars.remove(ticket);
    }
    public Car pickUp(Ticket ticket) {
        lastErrorMessage = "";

        if (ticket == null) {
            lastErrorMessage = "停车票不能为空";
            return null;
        }

        if (!ticket.isValid() || !parkedCars.containsKey(ticket)) {
            lastErrorMessage = "未识别的停车票";
            return null;
        }

        Car car = parkedCars.get(ticket);
        parkedCars.remove(ticket);
        ticket.invalidate();
        return car;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    public int getAvailableSpaces() {
        return capacity - parkedCars.size();
    }

    public int getCapacity() {
        return capacity;
    }
}