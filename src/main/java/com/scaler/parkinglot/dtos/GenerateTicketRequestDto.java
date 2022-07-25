package com.scaler.parkinglot.dtos;

import com.scaler.parkinglot.models.EntryGate;
import com.scaler.parkinglot.models.Vehicle;

public class GenerateTicketRequestDto {
    private Vehicle vehicle;
    private EntryGate entryGate;
    private Long parkingLotId;

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public EntryGate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(EntryGate entryGate) {
        this.entryGate = entryGate;
    }
}
