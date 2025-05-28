package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RateCardTest {
    // Tests if the calculate() returns the required value
    @Test
    void TestCalculate() {
        DataUsage usage = new DataUsage();
        usage.fourGHome = 100;
        usage.fiveGHome = 200;
        usage.fourGRoaming = 10;
        usage.fiveGRoaming = 20;
        RateCard ratecard = new RateCard(0.2, 0.5, 1000);

        double expectedCost = 133.7;
        assertEquals(expectedCost, ratecard.calculate(usage));

    }
}
