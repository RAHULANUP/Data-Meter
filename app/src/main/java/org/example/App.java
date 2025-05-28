package org.example;

import java.io.InputStream;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            InputStream inputStream = App.class.getClassLoader().getResourceAsStream("inputfile.txt");

            if (inputStream == null) {
                System.out.println("........................File not found in classpath!");
                return;
            }
            System.out.println("FILE FOUND");
            Scanner reader = new Scanner(inputStream);
            boolean hasLines = false;
            while (reader.hasNextLine()) {
                hasLines = true;
                String data = reader.nextLine();
                System.out.println(data);
            }
            if (hasLines == false) {
                System.out.println("FILE EMPTY");
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("An error occurred:");
            e.printStackTrace();
        }
    }
}
