package com.scaler.parkinglot.models;

public class ElectricParkingSpot extends ParkingSpot {
    private ElectricCharger eLectricCharger;

    public ElectricParkingSpot(ElectricCharger eLectricCharger) {
        this.eLectricCharger = eLectricCharger;
    }
}
