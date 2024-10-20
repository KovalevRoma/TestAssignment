# Bug Report

1) The issue with exceeding the upper limit of energy consumption percentage lies in the `driveTo` function of the `Car` class defined in the `Car.java` file: in cases where the destination is directly to the left of the starting point, the variable `distance` takes a negative value. When moving a negative distance, the `Car.energy.reduceEnergy` function works correctly and subtracts a negative number from the fuel counter. As a result, we end up with a situation where the fuel level increases as the car moves. The problem is solved by defining the `distance` variable as the absolute difference between the current position and the destination:

   ```java
   // double distance = destination - this.location;
   double distance = Math.abs(destination - this.location);
```

2) There was a mistake in the `getEnergy()` function when implementing the protected Energy class in the `Car.java` file: each time the method was called, the amount of energy increased. This is incorrect behavior for the method since its main task is to return the current fuel level of the car without changes. The issue can be resolved by ensuring that when `Car.Energy.getEnergy()` is called, the function returns the unchanged value of the energy variable:

   ```java
   	// public double getEnergy() { return energy++; }
   	public double getEnergy() { return energy; }
   ```
