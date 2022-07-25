package com.scaler.parkinglot.controllers;

import com.scaler.parkinglot.dtos.CreateParkingLotRequestDto;
import com.scaler.parkinglot.dtos.CreateParkingLotResponseDto;
import com.scaler.parkinglot.dtos.ResponseStatusDto;
import com.scaler.parkinglot.models.ParkingFloor;
import com.scaler.parkinglot.models.ParkingLot;
import com.scaler.parkinglot.services.ParkingLotService;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotController {
    private ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public CreateParkingLotResponseDto createParkingLot(
            CreateParkingLotRequestDto request
    ) {

        if (request.getNumberOfFloors() < 2) {
            CreateParkingLotResponseDto responseDto = new CreateParkingLotResponseDto();
            responseDto.setResponseStatus(ResponseStatusDto.FAILURE);
            return responseDto;
        }

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setAddress(request.getAddress());
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for (int i = 0; i < request.getNumberOfFloors(); ++i) {
            parkingFloors.add(new ParkingFloor());
        }
        parkingLot.setParkingFloors(parkingFloors);

        ParkingLot createdParkingLot = parkingLotService.createParkingLot(parkingLot);

        CreateParkingLotResponseDto response = new CreateParkingLotResponseDto();
        response.setParkingLot(createdParkingLot);
        response.setResponseStatus(ResponseStatusDto.SUCCESS);
        return response;
    }
}

// ParkingLotController.createParkingLot()
// dto ->  Data Transfer Object
// For every request from client,
// For every response to the client,
// We create a DTO