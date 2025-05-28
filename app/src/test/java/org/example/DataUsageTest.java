package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DataUsageTest {
    // Tests addUsage() if isRoaming is set to true
    @Test
    void TestaddUsageIsRoaming() {
        DataUsage usage = new DataUsage();
        usage.addUsage(true, 100, 200);
        double expected4GRoaming = 100;
        double expected5GRoaming = 200;
        assertEquals(expected4GRoaming, usage.fourGRoaming);
        assertEquals(expected5GRoaming, usage.fiveGRoaming);
    }

    // Tests addUsage() if isRoaming is set to false
    @Test
    void TestaddUsageIsNotRoaming() {
        DataUsage usage = new DataUsage();
        usage.addUsage(false, 100, 200);
        double expected4GHome = 100;
        double expected5GHome = 200;
        assertEquals(expected4GHome, usage.fourGHome);
        assertEquals(expected5GHome, usage.fiveGHome);
    }
}
