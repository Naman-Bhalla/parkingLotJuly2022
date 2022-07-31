package com.scaler.parkinglot.dtos;

import com.scaler.parkinglot.models.ParkingSpot;

public class AddSpotResponseDto extends ResponseDto{

    ParkingSpot createdSpot;

    public ParkingSpot getCreatedSpot() {
        return createdSpot;
    }

    public void setCreatedSpot(ParkingSpot createdSpot) {
        this.createdSpot = createdSpot;
    }
}
