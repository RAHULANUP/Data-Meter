package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FileReaderWriter {
    public DataAggregator aggregator;
    public DataParser parser;

    public FileReaderWriter(DataAggregator aggregator, DataParser parser) {
        this.aggregator = aggregator;
        this.parser = parser;
    }

    public void parseFiles(String[] fileList) {
        for (int fileCount = 0; fileCount < fileList.length; fileCount++) {
            parseFile(fileList[fileCount]);
        }
    }

    public void parseFile(String file) {
        InputStream fileinput = App.class.getClassLoader().getResourceAsStream(file);
        if (fileinput == null) {
            System.out.println("FILE IS NOT FOUND");
            return;
        }
        Scanner reader = new Scanner(fileinput);
        try {
            int linecount = 0;
            while (reader.hasNextLine()) {
                linecount++;
                String line = reader.nextLine();
                try {
                    DataRecord record = parser.parseEachLine(line);
                    aggregator.addRecord(record);
                } catch (Exception exception) {
                    System.out.println("ERROR OCCURED WHILE PARSING THE FILE on line number :" + linecount + "Message"
                            + exception.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            reader.close();
            try {
                fileinput.close();
            } catch (IOException e) {
                System.out.println("Error closing file" + e.getMessage());
            }
        }
    }

    public void generateOutput(RateCard ratecard) {
        System.out.println("Mobile Number  |  4G Home | 4G Roaming | 5G Home | 5G Roaming | Cost");
        for (String mobileNumber : aggregator.getAggregatedInfo().keySet()) {
            DataUsage usage = aggregator.aggregatedInfo.get(mobileNumber);
            double cost = ratecard.calculate(usage);
            System.out.println(mobileNumber + " " + usage.fourGHome + " " + usage.fourGRoaming + " " + usage.fiveGHome
                    + " " + usage.fiveGRoaming + " " + cost);
        }
    }
}
