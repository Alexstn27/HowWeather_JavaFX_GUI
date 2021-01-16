package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ChartClass {

    public void makeChart(List<Double> myVector) {

        Stage stage = new Stage();
        ReadFile readFile = new ReadFile();
        readFile.read();

        ArrayList<String> locationVector = (ArrayList<String>) readFile.getLocationVector();

        //Defining the x an y axes
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        //Setting labels for the axes

        xAxis.setLabel("Most recent data");

        if (myVector.equals(readFile.getTemperatureVector())) {
            yAxis.setLabel("Temperature(°C)");
        } else if (myVector.equals(readFile.getLightVector())) {
            yAxis.setLabel("Light");
        } else if (myVector.equals(readFile.getPressureVector())) {
            yAxis.setLabel("Pressure");
        }

        //Creating a line chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        //Preparing the data points for the line

        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();
        XYChart.Series series4 = new XYChart.Series();

        int counter = 0;
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int n = myVector.size();

        for (int i = n - 100; i < n; i++) {
            if (locationVector.get(i).contains("pysaxion")) {
                series1.getData().add(new XYChart.Data(counter, myVector.get(i)));
                counter++;
            } else if (locationVector.get(i).contains("pygronau")) {
                series2.getData().add(new XYChart.Data(counter1, myVector.get(i)));
                counter1++;
            } else if (locationVector.get(i).contains("pywierden")) {
                series3.getData().add(new XYChart.Data(counter2, myVector.get(i)));
                counter2++;
            } else if (locationVector.get(i).contains("pygarage")) {
                series4.getData().add(new XYChart.Data(counter3, myVector.get(i)));
                counter3++;
            }
        }

        series1.setName("pysaxion");
        series2.setName("pygronau");
        series3.setName("pywierden");
        series4.setName("pygarage");

        //Setting the data to Line chart
        lineChart.getData().addAll(series1, series2, series3, series4);
        //Creating a stack pane to hold the chart
        StackPane pane = new StackPane(lineChart);
        pane.setPadding(new Insets(15, 15, 15, 15));
        pane.setStyle("-fx-background-color: BEIGE");
        //Setting the Scene
        Scene scene = new Scene(pane, 595, 350);
        stage.setTitle("Line Chart");
        stage.setScene(scene);
        stage.show();

    }

}
