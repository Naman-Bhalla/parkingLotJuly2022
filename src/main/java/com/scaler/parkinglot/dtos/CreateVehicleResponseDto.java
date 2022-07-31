package com.scaler.parkinglot.dtos;

import com.scaler.parkinglot.models.Vehicle;

public class CreateVehicleResponseDto extends ResponseDto{


    Vehicle createdVehicle;

    public Vehicle getCreatedVehicle() {
        return createdVehicle;
    }

    public void setCreatedVehicle(Vehicle createdVehicle) {
        this.createdVehicle = createdVehicle;
    }



}
