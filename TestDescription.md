# Unit Test Report

## Project Overview

This project simulates the behavior of different types of cars (electric and petrol) and their interactions with a person who drives them to different locations (e.g., home, work). The system also includes a mechanism to refuel or recharge the cars when energy is low and uses a pool of charging and gas stations to find the nearest station.

### Classes Covered by Unit Tests:
- `Car`
  - Abstract class with subclasses `ElectricCar` and `PetrolCar`.
- `Person`
  - Manages a person driving cars between locations (home, work).
- `StationsPool`
  - Manages pools of gas stations and charging stations.

## Unit Test Summary

### 1. **CarTest.java**

The `CarTest` class focuses on testing different behaviors of the `Car` class, covering both `PetrolCar` and `ElectricCar`.

#### Scenarios Covered:
- **Driving to various destinations:**
  - Tested driving a petrol car and electric car over different distances.
  - Verified the change in car location and energy levels after driving.
  - Covered cases where energy usage rates vary to ensure correct depletion.
  
- **Refueling and recharging:**
  - Verified that after energy depletion, refueling brings the energy back to 100%.

- **Checking energy needs:**
  - Ensured the `needsEnergy()` function accurately detects when a car needs refueling/recharging.
  - Tested edge cases where a car does not need energy for short distances or when it does for longer ones.

- **Edge cases for driving:**
  - Verified behavior when driving zero distance (location should not change, and energy should not be consumed).
  - Tested long-distance driving with low energy usage rates to confirm proper energy depletion behavior.

#### Key Assertions:
- The car's location is updated correctly after a drive.
- The energy value changes according to the energy usage rate.
- The refuel and recharge behaviors restore energy levels back to 100%.

---

### 2. **PersonTest.java**

The `PersonTest` class ensures that the `Person` interacts correctly with cars, including handling edge cases like underage driving and switching cars.

#### Scenarios Covered:
- **Driving behavior:**
  - Verified that a person of legal age can drive to work and home with the car.
  - Ensured that underage persons cannot drive and that no location or energy changes occur.

- **Energy management during driving:**
  - Tested scenarios where the car needs refueling before reaching the destination.
  - Verified that if no refueling is needed (for short trips), the car's energy decreases correctly after driving.
  
- **Switching cars:**
  - Ensured that switching from one car (e.g., PetrolCar) to another (e.g., ElectricCar) works seamlessly and the person can continue driving with the new car.

#### Key Assertions:
- The car's location is correctly updated after the person drives it.
- The car refuels if energy is too low to complete a trip.
- Switching cars mid-journey does not cause issues.

---

### 3. **StationsPoolTest.java**

The `StationsPoolTest` ensures that the pool of stations (both gas and charging stations) correctly provides the nearest station for refueling or recharging based on the car's location.

#### Scenarios Covered:
- **Closest station search:**
  - Verified that the system correctly identifies the nearest gas station for petrol cars.
  - Ensured the nearest charging station is found for electric cars.

- **Edge cases:**
  - Tested cases where the car is already at a station.
  - Checked scenarios where the car is very far from all stations to ensure the system still finds the nearest station.

#### Key Assertions:
- The closest station (gas or charging) is correctly determined based on the car's current location.
- The system works even when the car is already at a station or when stations are far away.

---

## Edge Cases Covered

- **Zero-distance drive:** Ensures the car's location and energy remain unchanged when driving to the same place.
- **Underage driver:** Prevents driving for persons below the legal driving age.
- **Low energy usage rates:** Tests long-distance drives with minimal energy consumption to ensure proper tracking.
- **Switching cars:** Verified behavior when a person switches between different car types (electric and petrol) mid-scenario.
- **Extreme distances:** Tested the system's ability to find the nearest stations for cars far from any known station.

## Conclusion

The unit tests comprehensively cover the major functionalities of the project. These include normal scenarios of driving and energy management, as well as edge cases such as underage driving, switching cars, and handling extreme distances. The test suite ensures that all potential issues are caught early, and the program behaves as expected under various conditions.

### Test Coverage:
- **Car behavior:** Driving, energy consumption, refueling.
- **Person behavior:** Driving restrictions (age), energy management, car switching.
- **Station finding:** Identifying the nearest stations based on the car's location.

Overall, the tests provide solid coverage of the system's functionality, ensuring reliability in both common and uncommon scenarios.
