package org.example;

// DataParser class mainly focuses on parsing and extracting the information in the line read

public class DataParser {
    public String separator = "\\|"; // Pipe symbol is our separator that separates the necessary values
    public int numberOfValuesRequired = 5; // Mobile number, tower , 4G , 5G and roaming are the five values to be
                                           // obtained from each line in the file

    public DataRecord parseEachLine(String line) throws Exception {
        // This function reads the line and splits it into array of strings based on the
        // pipe separator
        // and creates a datarecord and returns it
        String[] values = line.trim().split(separator);

        if (values.length != numberOfValuesRequired) {
            throw new Exception("THERE IS SOME ISSUE WITH THE LINE PROCESSED");
        }
        String mobileNumber = values[0];
        String tower = values[1];
        double fourG = Double.parseDouble(values[2]);
        double fiveG = Double.parseDouble(values[3]);
        boolean isRoaming;
        if (values[4].equals("yes")) {
            isRoaming = true;
        } else {
            isRoaming = false;
        }
        return new DataRecord(mobileNumber, tower, fourG, fiveG, isRoaming);
    }

}
