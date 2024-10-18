package org.jetbrains.car;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ElectricCarTest {

  @Test
  void testElectricCarThreshold() {
    Car car = new ElectricCar(0, 1);
    assertFalse(car.needsEnergy(20));
    car.driveTo(60);
    assertTrue(car.needsEnergy(20));
  }
}
