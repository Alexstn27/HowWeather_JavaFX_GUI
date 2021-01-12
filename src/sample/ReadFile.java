package sample;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Vector;

public class ReadFile {
    public Vector<String> cacat(){
        Vector<String> vector = new Vector<String>(1000);

        try {
            File myObj = new File("myfile.txt");
            Scanner myReader = new Scanner(myObj);

            String sep2= "',";
            int sep4;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                sep4=data.indexOf(sep2);
                vector.add(data.substring(2,sep4));

                //System.out.println(vector);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return vector;
    }
}
