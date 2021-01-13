package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Button1 implements javafx.event.EventHandler<ActionEvent> {
    Vector<Double> lightVector = new Vector<Double>(1000);
    Button button;
    Main y = new Main();

    public void lightbutton(Stage primarystage) {
        primarystage.setTitle("Menu");
        button = new javafx.scene.control.Button();
        button.setText("Light");
        button.setOnAction(this);
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        primarystage.setScene(scene);
        primarystage.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stage = new Stage();
        File f = new File("/Users/stanalexandru/Downloads/Project Engineering Python/myfiledata.txt");


        if (actionEvent.getSource() == button) {
            Vector<Double> temperatureVector = new Vector<Double>(1000);
            Vector<Double> pressureVector = new Vector<Double>(1000);
            Vector<String> locationVector = new Vector<String>(1000);

            locationVector.addAll(0,y.getLocationVector());
            try {
                //s = new Scanner(f);
                //BufferedReader reader = new BufferedReader(new FileReader(f));
                Scanner pula=new Scanner(f);
                String sep1 = "', '";
                String sep2 = "', '";
                int sep4=0;


               for( int index=0; index<=locationVector.size(); index++){
                   System.out.println(locationVector.get(index));
               }
                int sepHelp1 = 0;
                int sepHelp2 = 0;
                while (pula.hasNextLine()) {

                    String data = pula.nextLine();
                   // System.out.println(data);

                    sepHelp1 = data.indexOf(sep1);
                    sepHelp2=data.lastIndexOf(sep2);
                    sep4 = data.indexOf(sep2);

                    lightVector.add(Double.parseDouble(data.substring(sepHelp1+4,sepHelp2-10)));


                    System.out.println(lightVector);
                }
                pula.close();

            } catch (Exception e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    }
