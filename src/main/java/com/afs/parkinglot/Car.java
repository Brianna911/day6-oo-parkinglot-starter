package com.afs.parkinglot;

public class Car {
    private String licensePlate;

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
    // Car类
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return licensePlate.equals(car.licensePlate);
    }

    @Override
    public int hashCode() {
        return licensePlate.hashCode();
    }

}