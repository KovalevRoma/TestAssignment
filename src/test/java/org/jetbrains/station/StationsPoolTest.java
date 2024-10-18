package org.jetbrains.station;

import org.jetbrains.car.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StationsPoolTest {

  @Test
  void testGetClosestChargingStation() {
    Car car = new ElectricCar(50, 2);
    ChargingStation station = StationsPool.getInstance().getClosestChargingStation(car);
    assertEquals(47, station.getLocation()); // Closest charging station to 50 is at 47
  }

  @Test
  void testGetClosestGasStation() {
    Car car = new PetrolCar(60, 2);
    GasStation station = StationsPool.getInstance().getClosestGasStation(car);
    assertEquals(67, station.getLocation()); // Closest gas station to 60 is at 67
  }
}
