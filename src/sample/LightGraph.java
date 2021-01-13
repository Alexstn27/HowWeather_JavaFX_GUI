package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Vector;

public class LightGraph {

    public void lightGraph(){
        Stage stage= new Stage();
        ReadFile readFile = new ReadFile();

        readFile.Read();

        Vector<String> locationVector = readFile.getLocationVector();
        Vector<Double> lightVector = readFile.getLightVector();



        for (int muie=0; muie<lightVector.size();muie++){
            System.out.println(lightVector.get(muie)+" "
                    +readFile.locationVector.get(muie));
        }

        //Defining the x an y axes
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        //Setting labels for the axes
        xAxis.setLabel("Month");
        yAxis.setLabel("Light");
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
        int n=lightVector.size();

        for (int i =n-50; i < n; i++) {
            if (locationVector.get(i).contains("pysaxion")) {
                series1.getData().add(new XYChart.Data(counter, lightVector.get(i)));
                counter++;
            } else if (locationVector.get(i).contains("pygronau")) {
                series2.getData().add(new XYChart.Data(counter1, lightVector.get(i)));
                counter1++;
            } else if (locationVector.get(i).contains("pywierden")) {
                series3.getData().add(new XYChart.Data(counter2, lightVector.get(i)));
                counter2++;
            } else if (locationVector.get(i).contains("pygarage")) {
                series4.getData().add(new XYChart.Data(counter3, lightVector.get(i)));
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
