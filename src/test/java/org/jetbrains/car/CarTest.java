package org.jetbrains.car;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

  @Test
  void testDriveToVariousDestinations() {
    // Test case 1: Driving with a PetrolCar and low energy usage rate
    Car car = new PetrolCar(0, 1);
    car.driveTo(50);  // drive 50 units
    assertEquals(50, car.getLocation(), "Car didn't arrive at the expected location.");
    assertEquals(50, car.getEnergyValue(), "Energy value is incorrect after driving.");

    // Test case 2: Driving with a higher energy usage rate
    car = new PetrolCar(10, 2);
    car.driveTo(30);  // drive 20 units
    assertEquals(30, car.getLocation(), "Car didn't arrive at the expected location.");
    assertEquals(60, car.getEnergyValue(), "Energy value is incorrect after driving.");

    // Test case 3: Driving with ElectricCar and full energy usage
    car = new ElectricCar(50, 10);
    car.driveTo(60);  // drive 10 units
    assertEquals(60, car.getLocation(), "Car didn't arrive at the expected location.");
    assertEquals(0, car.getEnergyValue(), "Energy value is incorrect after driving.");

    // Test case 4: Refueling after energy depletion
    car.refuel();
    assertEquals(100, car.getEnergyValue(), "Energy wasn't restored after refueling.");
  }

  @Test
  void testNeedsEnergy() {
    // Test case 1: PetrolCar does not need energy for short distance
    Car car = new PetrolCar(0, 1);
    assertFalse(car.needsEnergy(5), "Car should not need energy.");

    // Test case 2: PetrolCar needs energy for long distance
    car = new PetrolCar(0, 2);
    assertTrue(car.needsEnergy(60), "Car should need energy.");

    // Test case 3: ElectricCar needs energy sooner
    car = new ElectricCar(50, 5);
    assertTrue(car.needsEnergy(70), "Electric car should need energy at this point.");
  }

  @Test
  void testEdgeCasesForDriving() {
    // Test case 1: Driving zero distance
    Car car = new PetrolCar(0, 2);
    car.driveTo(0);
    assertEquals(0, car.getLocation(), "Car location should not change when driving to the same location.");
    assertEquals(100, car.getEnergyValue(), "Energy should not change when driving zero distance.");

    // Test case 2: Large distance with very low energy usage rate
    car = new PetrolCar(0, 0.01);
    car.driveTo(10000);  // Driving 10000 units
    assertEquals(10000, car.getLocation(), "Car should reach the destination even for large distances.");
    assertEquals(0, car.getEnergyValue(), "Energy should be depleted after a long drive.");
  }
}
