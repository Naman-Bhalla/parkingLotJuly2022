package com.scaler.parkinglot.dtos;

public class UpdateParkingLotRequestDto {
    private String address;
    private Long parkingLotId;

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
