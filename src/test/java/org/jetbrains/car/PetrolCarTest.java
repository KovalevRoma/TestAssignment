package org.jetbrains.car;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PetrolCarTest {

  @Test
  void testPetrolCarThreshold() {

    Car car = new PetrolCar(0, 1);
    assertFalse(car.needsEnergy(10)); // Check the threshold for PetrolCar
    car.driveTo(80);
    assertTrue(car.needsEnergy(10)); // Energy below 20
  }
}
