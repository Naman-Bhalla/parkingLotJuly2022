package com.scaler.parkinglot.controllers;

import com.scaler.parkinglot.dtos.GenerateTicketRequestDto;
import com.scaler.parkinglot.dtos.GenerateTicketResponseDto;
import com.scaler.parkinglot.dtos.ResponseStatusDto;
import com.scaler.parkinglot.models.Ticket;
import com.scaler.parkinglot.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(
            GenerateTicketRequestDto request
    ) {
      Ticket createdTicket =  ticketService.generateTicket(request.getParkingLotId(),request.getVehicle(),request.getSpotType(), request.getEntryGate());

      GenerateTicketResponseDto response=new GenerateTicketResponseDto();
      response.setTicket(createdTicket);
      response.setResponseStatus(ResponseStatusDto.SUCCESS);
      return response;

    }
}
