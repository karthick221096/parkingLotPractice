package com.karthick.parkinglot.controller;


import com.karthick.parkinglot.model.Ticket;
import com.karthick.parkinglot.model.Vehicle;
import com.karthick.parkinglot.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/book")
    public Ticket bookTicket(@RequestBody Vehicle vehicle){
        return ticketService.bookTicket(vehicle);
    }

    @PostMapping("/unbook")
    public Ticket unbookTicket(@RequestBody Ticket ticket){
        return ticketService.unbookTicket(ticket);
    }
}
