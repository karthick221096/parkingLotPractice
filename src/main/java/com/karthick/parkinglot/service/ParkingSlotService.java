package com.karthick.parkinglot.service;

import com.karthick.parkinglot.model.ParkingSlot;
import com.karthick.parkinglot.model.ParkingSlotType;
import com.karthick.parkinglot.model.VehicleType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class  ParkingSlotService {
    public List<ParkingSlot> parkingSlots = new ArrayList<>();

    private final Map<VehicleType,ParkingSlotType> VEHICLE_SLOT_MAPPING = Map.of(
            VehicleType.BIKE,ParkingSlotType.SMALL,
            VehicleType.CAR,ParkingSlotType.MEDIUM,
            VehicleType.TRUCK,ParkingSlotType.LARGE
    );




    public ParkingSlot getNearByParkingSlot(VehicleType vehicleType){


        ParkingSlotType requiredSlotType = VEHICLE_SLOT_MAPPING.get(vehicleType);

        if(requiredSlotType == null){
            //TODO Throw required Slot Type or vehicle type not available
            return null;
        }

        for (ParkingSlot slot : parkingSlots){
            if(slot.getParkingSlotType() == requiredSlotType && !slot.isOccupied()){
                return slot;
            }
        }

        //TODO handle logic for slot not available
        return null;

    }

    public List<ParkingSlot> getAvailableParkingSlot(){
        return parkingSlots.stream().filter(slot -> !slot.isOccupied()).collect(Collectors.toList());
    }
}
