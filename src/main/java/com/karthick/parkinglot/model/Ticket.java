package com.karthick.parkinglot.model;

import com.karthick.parkinglot.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Ticket extends BaseModel {
    private Vehicle vehicle;
    private Date parkedAt;
    private Date unParkedAt;
    private ParkingSlot parkingSlot;
    private double parkingPrice;
}
