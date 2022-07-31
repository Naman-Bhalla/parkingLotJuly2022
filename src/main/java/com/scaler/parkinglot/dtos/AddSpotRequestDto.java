package com.scaler.parkinglot.dtos;

import com.scaler.parkinglot.models.ParkingFloor;
import com.scaler.parkinglot.models.SpotType;

public class AddSpotRequestDto  extends ResponseDto{
    public int getParkingFloorNo() {
        return parkingFloorNo;
    }

    public void setParkingFloorNo(int parkingFloorNo) {
        this.parkingFloorNo = parkingFloorNo;
    }

    private int spotNumber;

    private int parkingFloorNo;

    private SpotType spotType;

    private Long parkingLotId;

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }



    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }



}
