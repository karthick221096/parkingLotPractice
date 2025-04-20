package com.karthick.parkinglot.model;

import com.karthick.parkinglot.BaseModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle extends BaseModel {


    private Integer vehicleNumber;
    private VehicleType vehicleType;

    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.setVehicleType(VehicleType.CAR);  // <- if this line has an error, Lombok isn't working
        System.out.println(v.getVehicleType());
    }


}
