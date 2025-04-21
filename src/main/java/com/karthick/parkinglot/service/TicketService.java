package com.karthick.parkinglot.service;

import com.karthick.parkinglot.model.ParkingSlot;
import com.karthick.parkinglot.model.Ticket;
import com.karthick.parkinglot.model.Vehicle;
import com.karthick.parkinglot.model.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TicketService {
    private final ParkingSlotService parkingSlotService;

    public TicketService (ParkingSlotService parkingSlotService){
        this.parkingSlotService = parkingSlotService;
    }
    public Ticket bookTicket(Vehicle vehicle){

        ParkingSlot slot = parkingSlotService.getNearByParkingSlot(vehicle.getVehicleType());
        if(slot == null){
            //TODO throw new NoAvailableSlotException();
            return null;
        }
        slot.setOccupied(true); // mark slot as taken

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setParkedAt(new Date());
        ticket.setParkingSlot(slot);
        System.out.println("ticket from Ticketservice"+ticket);
        return ticket;
    }

    public Ticket unbookTicket(Ticket ticket){
        if(ticket == null){
            //TODO Throw ticket is not valid exception
            return null;
        }

        ticket.setUnParkedAt(new Date());
        ticket.getParkingSlot().setOccupied(false);

        long duration = ticket.getUnParkedAt().getTime() - ticket.getParkedAt().getTime();
        double hours = Math.ceil(duration/(1000.0 * 60 * 60));
        ticket.setParkingPrice(hours * 20);
        return ticket;
    }
}
