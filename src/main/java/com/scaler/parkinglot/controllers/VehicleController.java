package com.scaler.parkinglot.controllers;

import com.scaler.parkinglot.dtos.CreateVehicleRequestDto;
import com.scaler.parkinglot.dtos.CreateVehicleResponseDto;
import com.scaler.parkinglot.dtos.ResponseStatusDto;
import com.scaler.parkinglot.models.Vehicle;
import com.scaler.parkinglot.services.VehicleService;

public class VehicleController {


    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
            this.vehicleService=vehicleService;
    }

    CreateVehicleResponseDto createVehicle(CreateVehicleRequestDto request)
    {

        Vehicle createdVehicle= vehicleService.createVehicle(request.getNumber(),request.getVehicleType());


        CreateVehicleResponseDto response= new CreateVehicleResponseDto();
        response.setCreatedVehicle(createdVehicle);
        response.setResponseStatus(ResponseStatusDto.SUCCESS);

        return response;
    }

}
