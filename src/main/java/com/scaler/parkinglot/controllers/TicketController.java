package com.scaler.parkinglot.controllers;

import com.scaler.parkinglot.dtos.GenerateTicketRequestDto;
import com.scaler.parkinglot.dtos.GenerateTicketResponseDto;
import com.scaler.parkinglot.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(
            GenerateTicketRequestDto request
    ) {
        return null;
    }
}
