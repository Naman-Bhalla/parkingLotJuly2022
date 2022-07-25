package com.scaler.parkinglot.dtos;

import com.scaler.parkinglot.models.ParkingLot;

public class CreateParkingLotResponseDto {
    private ParkingLot parkingLot;
    private ResponseStatusDto responseStatus;
//    private Response

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ResponseStatusDto getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatusDto responseStatus) {
        this.responseStatus = responseStatus;
    }
}
