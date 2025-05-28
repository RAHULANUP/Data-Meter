package org.example;

// RateCard is the class used to initialize the 4G rates, 5G rates and the threshold values and calculate the cost

public class RateCard {
    public double fourGRate;
    public double fiveGRate;
    public double threshold;

    public RateCard(double fourGRate, double fiveGRate, double threshold) {
        this.fourGRate = fourGRate;
        this.fiveGRate = fiveGRate;
        this.threshold = threshold;
    }

    // calculate method takes in the datausage value and performs the calculation
    // required based on the 4G home, 4G roaming, 5G home ,5G roaming
    public double calculate(DataUsage usage) {
        double cost = 0;
        cost = cost + usage.fourGHome * fourGRate;
        cost = cost + usage.fiveGHome * fiveGRate;
        cost = cost + usage.fourGRoaming * (fourGRate * 1.10); // 10% more -> 4G rate
        cost = cost + usage.fiveGRoaming * (fiveGRate * 1.15); // 15% more -> 5G rate
        if (usage.getTotalUsage() > threshold) {
            cost = cost + cost * 0.05; // Adding 5% if the total usage is higher than threshold
        }
        return cost;

    }
}
