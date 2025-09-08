package com.afs.parkinglot;

// ParkingResult.java
public class ParkingResult {
    private final Car car;
    private final String errorMessage;

    public ParkingResult(Car car, String errorMessage) {
        this.car = car;
        this.errorMessage = errorMessage;
    }

    public Car getCar() {
        return car;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isSuccess() {
        return errorMessage == null;
    }
}