package com.scaler.parkinglot.services;

import com.scaler.parkinglot.models.Vehicle;
import com.scaler.parkinglot.models.VehicleType;
import com.scaler.parkinglot.repositories.VehicleRepository;

public class VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository)
    {
        this.vehicleRepository=vehicleRepository;
    }

    public Vehicle createVehicle(String number, VehicleType vehicleType)
    {

        Vehicle createdVehicle = new Vehicle();
        createdVehicle.setVehicleType(vehicleType);
        createdVehicle.setNumber(number);

        vehicleRepository.save(createdVehicle);
        return createdVehicle;
    }
}
