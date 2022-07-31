package com.scaler.parkinglot.services;

import com.scaler.parkinglot.controllers.ParkingLotController;
import com.scaler.parkinglot.models.*;
import com.scaler.parkinglot.repositories.ParkingLotRepository;

import java.util.List;

public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLot createParkingLot(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    public ParkingLot updateAddress(Long id, String newAddress) {
        // 1. Get current Parking Lot
        // 2. Update rhe address
        // 3. Save
        // 4. Return
        ParkingLot curentParkingLot = parkingLotRepository.getById(id);
        curentParkingLot.setAddress(newAddress);
        ParkingLot updatedParkingLot = parkingLotRepository.update(
                id, curentParkingLot
        );

        return updatedParkingLot;
    }

    public ParkingSpot addSpotToParkingLot(long parkingLotId, SpotType spotType, int spotNo, int floorNo)
    {
        ParkingLot parkingLot=parkingLotRepository.getById(parkingLotId);
        ParkingFloor floor=parkingLot.getParkingFloors().get(floorNo);

        ParkingSpot createdSpot= new ParkingSpot();
        createdSpot.setSpotNumber(spotNo);
        createdSpot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        createdSpot.setSpotType(spotType);
        createdSpot.setParkingFloor(floor);


        floor.getParkingSpots().add(createdSpot);
        parkingLot.getParkingFloors().set(floorNo,floor);

        parkingLotRepository.update(parkingLotId,parkingLot);


//        if(floor.getParkingSpots().add(createdSpot))
//        {
            return createdSpot;
//        }
//        return null;
    }


}
