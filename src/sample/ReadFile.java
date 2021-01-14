package sample;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

    final ArrayList<Double> temperatureVector;
    final ArrayList<Double> lightVector;
    final ArrayList<Double> pressureVector;
    final ArrayList<String> locationVector;

    public ReadFile() {

        temperatureVector = new ArrayList<>();
        lightVector = new ArrayList<>();
        pressureVector = new ArrayList<>();
        locationVector = new ArrayList<>();
    }

    public void read() {

        String listingFolder = "/Users/stanalexandru/Downloads/Project Engineering Python/myfiledata.txt";
        File f = new File(listingFolder);

        try {
            Scanner read = new Scanner(f);

            String[] helper;

            double temp;
            double light;
            double pressure;
            String location;

            while (read.hasNextLine()) {
                String data = read.nextLine();

                helper = data.split("'");
                temp = Double.parseDouble(helper[1]);
                light = Double.parseDouble(helper[3]);
                pressure = Double.parseDouble(helper[5]);
                location = helper[7];

                temperatureVector.add(temp);
                lightVector.add(light);
                locationVector.add(location);
                pressureVector.add(pressure);
            }
            read.close();

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public List<Double> getTemperatureVector() {
        return temperatureVector;
    }

    public List<Double> getLightVector() {
        return lightVector;
    }

    public List<Double> getPressureVector() {
        return pressureVector;
    }

    public List<String> getLocationVector() {
        return locationVector;
    }
}
