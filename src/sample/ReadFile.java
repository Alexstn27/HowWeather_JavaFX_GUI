package sample;

import java.io.BufferedReader;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Vector;

public class ReadFile {

    Vector<Double> temperatureVector = new Vector<Double>(1000);
    Vector<Double> lightVector = new Vector<Double>(1000);
    Vector<Double> pressureVector = new Vector<Double>(1000);
    Vector<String> locationVector = new Vector<String>(1000);

    public void Read() {

        File f = new File("/Users/stanalexandru/Downloads/Project Engineering Python/myfiledata.txt");

        try {
            Scanner read = new Scanner(f);

            String[] helper;

            double temp;
            double light;
            double pressure;
            String location;

            while (read.hasNextLine()) {
                String data = read.nextLine();

                helper=data.split("'");
                temp=Double.parseDouble(helper[1]);
                light=Double.parseDouble(helper[3]);
                pressure=Double.parseDouble(helper[5]);
                location=helper[7];

                temperatureVector.add(temp);
                lightVector.add(light);
                locationVector.add(location);
                pressureVector.add(pressure);
            }

//            for (int muie=0; muie<temperatureVector.size();muie++){
//                System.out.println(temperatureVector.get(muie)+" "
//                        +lightVector.get(muie)+" "
//                        +pressureVector.get(muie)+" "
//                        +locationVector.get(muie));
//            }

            read.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void populeaza(Vector<Double> temperaturi){
        temperaturi=temperatureVector;
    }

    public Vector<Double> getTemperatureVector() {
        return temperatureVector;
    }

    public Vector<Double> getLightVector() {
        return lightVector;
    }

    public Vector<Double> getPressureVector() {
        return pressureVector;
    }

    public Vector<String> getLocationVector() {
        return locationVector;
    }
}
