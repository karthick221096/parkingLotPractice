package com.karthick.parkinglot.model;



public class LombokTest {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.setVehicleType(VehicleType.CAR);
        System.out.println("Type: " + v.getVehicleType());
    }
}