package org.example;

// DataRecord class is the basic structure of a record present in the file
// mobilenumber,towername,4G,5G,isRoaming (5 Fields)
public class DataRecord {
    String mobileNumber;
    String tower;
    double fourG;
    double fiveG;
    boolean isRoaming;

    public DataRecord(String mobileNumber, String tower, double fourG, double fiveG, boolean isRoaming) {
        this.mobileNumber = mobileNumber;
        this.tower = tower;
        this.fourG = fourG;
        this.fiveG = fiveG;
        this.isRoaming = isRoaming;
    }

}
