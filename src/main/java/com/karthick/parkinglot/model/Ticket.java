package com.karthick.parkinglot.model;

import com.karthick.parkinglot.BaseModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket extends BaseModel {

    Vehicle vehicle;

}
