package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
//import java.awt.event.ActionEvent;
//import java.beans.EventHandler;

public class Main extends Application implements javafx.event.EventHandler<ActionEvent> {

    Button button;
    Button button1;

    @Override
    public void start(Stage primarystage) throws Exception{
        primarystage.setTitle("Menu");
        button = new Button();
        //button1 = new Button();
        button.setText("Temperature");
        //button1.setText("Light");
        button.setOnAction(this);
        //button1.setOnAction(this);

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        //layout.getChildren().add(button1);

        Scene scene = new Scene(layout, 300,250);
        //Scene scene1 = new Scene(layout, 500, 600);
        primarystage.setScene(scene);
       // primarystage.setScene(scene1);
        primarystage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stage= new Stage();
            if (actionEvent.getSource() == button) {
                Vector<Double> temperatureVector = new Vector<Double>(1000);
                Vector<Integer> lightVector = new Vector<Integer>(1000);
                Vector<Double> pressureVector = new Vector<Double>(1000);
                Vector<String> locationVector = new Vector<String>(1000);


                try {
                    File myObj = new File("myfile.txt");
                    Scanner myReader = new Scanner(myObj);

                    String sep2 = "',";
                    int sep4;

                    String sepLocation = ", '";
                    String sepLocation2 = "')";
                    int sepLoc = 0;
                    int sepLoc2 = 0;
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();

                        sep4 = data.indexOf(sep2);
                        sepLoc = data.lastIndexOf(sepLocation);
                        sepLoc2 = data.lastIndexOf(sepLocation2);

                        temperatureVector.add(Double.parseDouble(data.substring(2, sep4)));
                        locationVector.add(data.substring(sepLoc, sepLoc2));

                        // System.out.println(locationVector);
                    }
                    myReader.close();

                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }


                //Defining the x an y axes
                NumberAxis xAxis = new NumberAxis();
                NumberAxis yAxis = new NumberAxis();
                //Setting labels for the axes
                xAxis.setLabel("Month");
                yAxis.setLabel("Temperature(°C)");
                //Creating a line chart
                LineChart<Number, Number> linechart = new LineChart<Number, Number>(xAxis, yAxis);

                //Preparing the data points for the line1

                // XYChart.Series series1 = new XYChart.Series();
                XYChart.Series series1 = new XYChart.Series();
                XYChart.Series series2 = new XYChart.Series();
                XYChart.Series series3 = new XYChart.Series();
                XYChart.Series series4 = new XYChart.Series();

                int counter = 0;
                int counter1 = 0;
                int counter2 = 0;
                int counter3 = 0;

                for (int i = 0; i <= 50; i++) {
                    if (locationVector.get(i).contains("pysaxion")) {
                        series1.getData().add(new XYChart.Data(counter, temperatureVector.get(i)));
//                series1.getData().add(new XYChart.Data("Ian", temperatureVector.get(0)));
//                series1.getData().add(new XYChart.Data("feb", 8.9));
//                series1.getData().add(new XYChart.Data("Mar", temperatureVector.get(2)));
                        counter++;
                    } else if (locationVector.get(i).contains("pygronau")) {
                        series2.getData().add(new XYChart.Data(counter1, temperatureVector.get(i)));

//                series22.getData().add(new XYChart.Data(counter, temperatureVector.get(1)));
//                series22.getData().add(new XYChart.Data(counter, 0.8));
//                series22.getData().add(new XYChart.Data(counter, 3));
                        counter1++;
                    } else if (locationVector.get(i).contains("pywierden")) {
                        series3.getData().add(new XYChart.Data(counter2, temperatureVector.get(i)));

//                series33.getData().add(new XYChart.Data(counter, temperatureVector.get(2)));
//                series33.getData().add(new XYChart.Data(counter, 4.2));
//                series33.getData().add(new XYChart.Data(counter, 5.7));
                        counter2++;
                    } else if (locationVector.get(i).contains("pygarage")) {
                        series4.getData().add(new XYChart.Data(counter3, temperatureVector.get(i)));

//                series4.getData().add(new XYChart.Data(counter, -4));
//                series4.getData().add(new XYChart.Data(counter, -2.5));
//                series4.getData().add(new XYChart.Data(counter, -9.3));
                        counter3++;
                    }
                    // counter++;
                }

                series1.setName("pysaxion");
                series2.setName("pygronau");
                series3.setName("pywierden");
                series4.setName("pygarage");


                //Setting the data to Line chart
                linechart.getData().addAll(series1, series2, series3, series4);
                //Creating a stack pane to hold the chart
                StackPane pane = new StackPane(linechart);
                pane.setPadding(new Insets(15, 15, 15, 15));
                pane.setStyle("-fx-background-color: BEIGE");
                //Setting the Scene
                Scene scene = new Scene(pane, 595, 350);
                stage.setTitle("Line Chart");
                stage.setScene(scene);
                stage.show();

            }

        }

    }

