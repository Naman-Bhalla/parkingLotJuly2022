package com.scaler.parkinglot.repositories;

import com.scaler.parkinglot.models.ParkingLot;
import com.scaler.parkinglot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    private Map<Long, Ticket> tickets = new HashMap<>();

    private Long lastCount = 0L;

    public Ticket save(Ticket ticket) {
        lastCount += 1;
        ticket.setId(lastCount);
        tickets.put(lastCount, ticket);
        return ticket;
    }
}
