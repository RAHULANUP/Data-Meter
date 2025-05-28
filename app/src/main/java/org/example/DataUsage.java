package org.example;

// DataUsage class shows the basic layout of the usage information
// 4GHome,5GHome,4GRoaming,5GRoaming

public class DataUsage {
    double fourGHome = 0;
    double fiveGHome = 0;
    double fourGRoaming = 0;
    double fiveGRoaming = 0;

    public void addUsage(boolean isRoaming, double fourG, double fiveG) {

        // This function checks the isRoaming variable and if isRoaming==true then add
        // the values to fourGRoaming and fiveGRoaming else add to the fourGHome and
        // fiveGHome
        if (isRoaming) {
            this.fourGRoaming += fourG;
            this.fiveGRoaming += fiveG;
        } else {
            this.fourGHome += fourG;
            this.fiveGHome += fiveG;
        }
    }

    public double getTotalUsage() {
        // Return total usage (add all the usage)
        return fourGHome + fiveGHome + fourGRoaming + fiveGRoaming;
    }
}
