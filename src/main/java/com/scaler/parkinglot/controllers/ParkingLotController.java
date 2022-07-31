package com.scaler.parkinglot.controllers;

import com.scaler.parkinglot.dtos.*;
import com.scaler.parkinglot.models.ParkingFloor;
import com.scaler.parkinglot.models.ParkingLot;
import com.scaler.parkinglot.models.ParkingSpot;
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


    public UpdateParkingLotResponseDto updateAddress(UpdateParkingLotRequestDto request) {
        ParkingLot updatedParkingLot = parkingLotService.updateAddress(
                request.getParkingLotId(), request.getAddress()
        );

        UpdateParkingLotResponseDto responseDto = new UpdateParkingLotResponseDto();
        responseDto.setParkingLot(updatedParkingLot);
        responseDto.setResponseStatus(ResponseStatusDto.SUCCESS);
        return responseDto;
    }

    public AddSpotResponseDto addSpotToParkingLot(AddSpotRequestDto request)
    {

      ParkingSpot createdSpot= parkingLotService.addSpotToParkingLot(request.getParkingLotId(),request.getSpotType(),
                                                request.getSpotNumber(), request.getParkingFloorNo() );

      AddSpotResponseDto response = new AddSpotResponseDto();
      response.setCreatedSpot(createdSpot);

      if(createdSpot==null)
          response.setResponseStatus(ResponseStatusDto.FAILURE);
      else
        response.setResponseStatus(ResponseStatusDto.SUCCESS);
      return response;

    }
}

// ParkingLotController.createParkingLot()
// dto ->  Data Transfer Object
// For every request from client,
// For every response to the client,
// We create a DTO