package com.scaler.parkinglot.repositories;


import com.scaler.parkinglot.models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {

    private Map<Long, Vehicle> vehicles = new HashMap<>();

    private Long lastCount = 0L;

    public Vehicle save(Vehicle vehicle) {
        lastCount += 1;
        vehicle.setId(lastCount);
        vehicles.put(lastCount,vehicle);
        return vehicle;
    }



}
