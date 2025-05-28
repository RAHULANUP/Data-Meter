package org.example;

import java.io.InputStream;
import java.util.Scanner;

public class App {
    public FileReaderWriter fileReaderWriter;
    public RateCard ratecard;

    public App(RateCard ratecard) {
        this.ratecard = ratecard;
        DataParser dataParser = new DataParser();
        DataAggregator aggregator = new DataAggregator();
        this.fileReaderWriter = new FileReaderWriter(aggregator, dataParser);
    }

    public static void main(String[] args) {
        String[] input = { "inputfile.txt", "inputfile01.txt" };
        RateCard ratecard = new RateCard(0.2, 0.5, 1000);
        App app = new App(ratecard);
        app.fileReaderWriter.parseFiles(input);
        app.fileReaderWriter.generateOutput(ratecard);
    }
}
