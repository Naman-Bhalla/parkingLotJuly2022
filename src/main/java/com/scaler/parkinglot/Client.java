package com.scaler.parkinglot;

import com.scaler.parkinglot.controllers.ParkingLotController;
import com.scaler.parkinglot.controllers.TicketController;
import com.scaler.parkinglot.controllers.VehicleController;
import com.scaler.parkinglot.dtos.*;
import com.scaler.parkinglot.models.ParkingLot;
import com.scaler.parkinglot.repositories.ParkingLotRepository;
import com.scaler.parkinglot.repositories.TicketRepository;
import com.scaler.parkinglot.repositories.VehicleRepository;
import com.scaler.parkinglot.services.ParkingLotService;
import com.scaler.parkinglot.services.TicketService;
import com.scaler.parkinglot.services.VehicleService;
import com.scaler.parkinglot.strategies.spotassignmentstrategy.RandomSpotAssignmentStrategy;
import com.scaler.parkinglot.strategies.spotassignmentstrategy.SpotAssignmentStrategy;


public class Client {

    public static void main(String[] args) {
        ObjectRegistry.put("parkingLotRepository", new ParkingLotRepository());
        ObjectRegistry.put("parkingLotService", new ParkingLotService(
                (ParkingLotRepository) ObjectRegistry.get("parkingLotRepository")
        ));
        ObjectRegistry.put("parkingLotController", new ParkingLotController(
                (ParkingLotService) ObjectRegistry.get("parkingLotService")
        ));
        ObjectRegistry.put("ticketRepository", new TicketRepository());
        ObjectRegistry.put("spotAssignmentStrategy", new RandomSpotAssignmentStrategy());
        ObjectRegistry.put("ticketService", new TicketService(
                (TicketRepository) ObjectRegistry.get("ticketRepository"),
                (SpotAssignmentStrategy) ObjectRegistry.get("spotAssignmentStrategy"),
                (ParkingLotRepository) ObjectRegistry.get("parkingLotRepository")
        ));
        ObjectRegistry.put("ticketController", new TicketController(
                (TicketService) ObjectRegistry.get("ticketService")
        ));

        ObjectRegistry.put("vehicleRepository",new VehicleRepository());
        ObjectRegistry.put("vehicleService", new VehicleService((VehicleRepository) ObjectRegistry.get("vehicleRepository")));
        ObjectRegistry.put("vehicleController", new VehicleController((VehicleService) ObjectRegistry.get("vehicleService")));



        ParkingLotController parkingLotController = (ParkingLotController) ObjectRegistry.get("parkingLotController");
        CreateParkingLotRequestDto request = new CreateParkingLotRequestDto();
        request.setAddress("Delhi Airport");
        request.setNumberOfFloors(4);

        CreateParkingLotResponseDto response =
                parkingLotController.createParkingLot(request);

        if (response.getResponseStatus().equals(ResponseStatusDto.FAILURE)) {
            System.out.println("Something is wrong");
        } else {
            System.out.println(response.getParkingLot());
        }

        UpdateParkingLotRequestDto updateParkingLotRequest = new UpdateParkingLotRequestDto();
        updateParkingLotRequest.setParkingLotId(1L);
        updateParkingLotRequest.setAddress("Noida");

        UpdateParkingLotResponseDto responseDto = parkingLotController.updateAddress(updateParkingLotRequest);

        System.out.println(responseDto);
    }
}

// I want a feature to update the address for a ParkingLot
// 2 waqys to structure of code
// 1. Package by Layer:
//      Have all the models together
//      Have all the services together
// 2. Package by feature:
//      Have everything related to 1 feature together
//      ..../parkingLot
//                     /ParkingLotController
//                     /ParkingLotService
//                     /ParkingLot
//                     /ParkingLotRepository
//                     /ParkingLotUtils
// Google prefers Package BY Feature

// Break till 10:53
// 1. Try to implement updateAddress()
//  /parkingLot/create
//  /tickets/create