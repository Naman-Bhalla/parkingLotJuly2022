package com.scaler.parkinglot.repositories;

import com.scaler.parkinglot.models.ParkingLot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLots = new HashMap<>();
    private Long lastCount = 0L;

    public ParkingLot save(ParkingLot parkingLot) {
        lastCount += 1;
        parkingLot.setId(lastCount);
        parkingLots.put(lastCount, parkingLot);
        return parkingLot;
    }
}
