package org.example;

public class DataUsage {
    double fourGHome;
    double fiveGHome;
    double fourGRoaming;
    double fiveGRoaming;

    public void addUsage(boolean isRoaming, double fourG, double fiveG) {
        if (isRoaming) {
            this.fourGRoaming += fourG;
            this.fiveGRoaming += fiveG;
        } else {
            this.fourGHome += fourG;
            this.fiveGHome += fiveG;
        }
    }

    public double getTotalUsage() {
        return fourGHome + fiveGHome + fourGRoaming + fiveGRoaming;
    }
}
