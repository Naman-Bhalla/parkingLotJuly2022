package com.scaler.parkinglot.dtos;

import com.scaler.parkinglot.models.VehicleType;

public class CreateVehicleRequestDto extends  ResponseDto{

    private  String number;
    private VehicleType vehicleType;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
