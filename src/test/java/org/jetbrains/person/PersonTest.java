package org.jetbrains.person;

import org.jetbrains.car.*;
import org.jetbrains.station.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Car car = new PetrolCar(10, 2);

    @Test
    void testPersonDriveToWorkAndHome() {
        Person person = new Person(19, 10.1, 46.1, car);

        person.goToWork();
        assertEquals(46.1, car.getLocation());
        assertTrue(car.getEnergyValue() > 0);

        person.goToHome();
        assertEquals(10.1, car.getLocation());
        assertTrue(car.getEnergyValue() > 0);
    }

    @Test
    void testPersonTooYoungToDrive() {
        Person person = new Person(16, 10.1, 46.1, car);

        person.goToWork(); // Should not drive
        assertEquals(10, car.getLocation()); // Car shouldn't move
    }

    @Test
    void testPersonWithLowEnergy() {
        Person person = new Person(19, 10.1, 46.1, car);

        car.driveTo(90);
        assertTrue(car.needsEnergy(46.1));
        person.goToWork();
        assertEquals(46.1, car.getLocation());
        assertEquals(14.2, car.getEnergyValue());
    }

    @Test
    void testChangeCar() {
        Car petrolCar = new PetrolCar(0, 2);
        Person person = new Person(20, 10, 50, petrolCar);

        person.goToWork();
        assertEquals(50, petrolCar.getLocation());

        Car electricCar = new ElectricCar(0, 1);
        person.changeCar(electricCar);

        person.goToHome();
        assertEquals(10, electricCar.getLocation());
    }

    @Test
    void testNullCarInPerson() {
        assertThrows(IllegalArgumentException.class, () -> new Person(19, 10.1, 46.1, null));
    }
}
