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

public class Main extends Application implements javafx.event.EventHandler<ActionEvent> {

    Button button;
    Button button1;
    Vector<String> locationVector = new Vector<String>(1000);

    public Vector<String> getLocationVector(){
        return locationVector;
    }

    @Override
    public void start(Stage primarystage) {
        primarystage.setTitle("Menu");
        button = new Button();
        button.setText("Temperature");
        button.setOnAction(this);
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300,250);
        primarystage.setScene(scene);
        primarystage.show();
        Button1 muie=new Button1();

//        muie.lightbutton(primarystage);

        ReadFile abc = new ReadFile();
        abc.Read();
        TemperatureGraph temperatureGraph= new TemperatureGraph();
        temperatureGraph.temperatureGraph();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stage= new Stage();
        File f=new File("/Users/stanalexandru/Downloads/Project Engineering Python/myfiledata.txt");
        Scanner s;

            if (actionEvent.getSource() == button) {
                Vector<Double> temperatureVector = new Vector<Double>(1000);
                Vector<Integer> lightVector = new Vector<Integer>(1000);
                Vector<Double> pressureVector = new Vector<Double>(1000);


                try {
                    s=new Scanner(f);
                    BufferedReader reader=new BufferedReader(new FileReader(f));
                    String sep2 = "',";
                    int sep4;

                    String sepLocation = ", '";
                    String sepLocation2 = "')";
                    int sepLoc = 0;
                    int sepLoc2 = 0;
                    while (reader.readLine()!=null) {
                        String data = reader.readLine();
                        sep4 = data.indexOf(sep2);
                        sepLoc = data.lastIndexOf(sepLocation);
                        sepLoc2 = data.lastIndexOf(sepLocation2);
                        temperatureVector.add(Double.parseDouble(data.substring(2, sep4)));
                        locationVector.add(data.substring(sepLoc, sepLoc2));
                    }
                    reader.close();

                } catch (Exception e) {
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

                XYChart.Series series1 = new XYChart.Series();
                XYChart.Series series2 = new XYChart.Series();
                XYChart.Series series3 = new XYChart.Series();
                XYChart.Series series4 = new XYChart.Series();

                int counter = 0;
                int counter1 = 0;
                int counter2 = 0;
                int counter3 = 0;
                int n=temperatureVector.size();

                for (int i =n-50; i < n; i++) {
                    if (locationVector.get(i).contains("pysaxion")) {
                        series1.getData().add(new XYChart.Data(counter, temperatureVector.get(i)));
                        counter++;
                    } else if (locationVector.get(i).contains("pygronau")) {
                        series2.getData().add(new XYChart.Data(counter1, temperatureVector.get(i)));
                        counter1++;
                    } else if (locationVector.get(i).contains("pywierden")) {
                        series3.getData().add(new XYChart.Data(counter2, temperatureVector.get(i)));
                        counter2++;
                    } else if (locationVector.get(i).contains("pygarage")) {
                        series4.getData().add(new XYChart.Data(counter3, temperatureVector.get(i)));
                        counter3++;
                    }
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

