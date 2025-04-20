package com.karthick.parkinglot.model;

import com.karthick.parkinglot.BaseModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSlot extends BaseModel {
    private ParkingSlotType parkingSlotType;
    private boolean isOccupied;
    private int distanceFromEntryGate;
    private Vehicle currentVehicle;
}
