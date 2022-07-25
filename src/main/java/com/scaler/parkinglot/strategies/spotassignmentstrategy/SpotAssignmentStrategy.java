package com.scaler.parkinglot.strategies.spotassignmentstrategy;

import com.scaler.parkinglot.models.*;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(ParkingLot parkingLot,
                           SpotType spotType,
                           EntryGate entryGate);
}
