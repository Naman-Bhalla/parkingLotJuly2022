package com.scaler.parkinglot;

import com.scaler.parkinglot.controllers.ParkingLotController;
import com.scaler.parkinglot.dtos.CreateParkingLotRequestDto;
import com.scaler.parkinglot.dtos.CreateParkingLotResponseDto;
import com.scaler.parkinglot.dtos.ResponseStatusDto;
import com.scaler.parkinglot.models.ParkingLot;
import com.scaler.parkinglot.repositories.ParkingLotRepository;
import com.scaler.parkinglot.services.ParkingLotService;

public class Client {

    public static void main(String[] args) {
        ObjectRegistry.put("parkingLotRepository", new ParkingLotRepository());
        ObjectRegistry.put("parkingLotService", new ParkingLotService(
                (ParkingLotRepository) ObjectRegistry.get("parkingLotRepository")
        ));
        ObjectRegistry.put("parkingLotController", new ParkingLotController(
                (ParkingLotService) ObjectRegistry.get("parkingLotService")
        ));


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
    }
}

// I want a feature to update the address for a ParkingLot