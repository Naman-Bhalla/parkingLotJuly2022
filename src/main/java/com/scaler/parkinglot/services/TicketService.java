package com.scaler.parkinglot.services;

import com.scaler.parkinglot.controllers.TicketController;
import com.scaler.parkinglot.models.*;
import com.scaler.parkinglot.repositories.ParkingLotRepository;
import com.scaler.parkinglot.repositories.TicketRepository;
import com.scaler.parkinglot.strategies.spotassignmentstrategy.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {
    private TicketRepository ticketRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;

    public TicketService(TicketRepository ticketRepository,
                         SpotAssignmentStrategy spotAssignmentStrategy,
                         ParkingLotRepository parkingLotRepository) {
        this.ticketRepository = ticketRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Ticket generateTicket(Long parkingLotId, Vehicle vehicle, SpotType spotType, EntryGate entryGate) {
        // 1. Find a spot
        //
        ParkingLot parkingLot = parkingLotRepository.getById(parkingLotId);

        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(
                parkingLot,
                spotType,
                entryGate
        );

        if (parkingLot == null) {
            return null;
        }

        Ticket ticket = new Ticket();
        ticket.setEntryGate(entryGate);
        ticket.setGeneratedBy(entryGate.getOperator());
        ticket.setParkingSpot(parkingSpot);
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(new Date());


        return ticket;
    }
}

// Assignment:
// 1. Implement the code in the Ticket Controller
//    - Get details from request and call the service. Return response object.
// 2. Implement ticket repository and save the generated ticket into it.
// 3. Implement following use case:
//    a.) Create a new vehicle -> Vehicle Controller
//    b.) Add a spot of a type to a follor of a parking lot -> ParkingLot Controller