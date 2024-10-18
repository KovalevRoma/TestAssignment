package org.jetbrains.station;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StationTest {

  @Test
  void testStationProperties() {
    Station station = new GasStation(1, 10);
    assertEquals(10, station.getLocation());
  }
}
