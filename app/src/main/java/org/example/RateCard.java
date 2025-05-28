package org.example;

public class RateCard {
    public double fourGRate;
    public double fiveGRate;
    public double threshold;

    public RateCard(double fourGRate, double fiveGRate, double threshold) {
        this.fourGRate = fourGRate;
        this.fiveGRate = fiveGRate;
        this.threshold = threshold;
    }

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
