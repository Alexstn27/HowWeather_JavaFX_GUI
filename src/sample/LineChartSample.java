package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class LineChartSample extends Application{

        @Override public void start(Stage stage) {

            Vector<Double> vector = new Vector<Double>(1000);

            try {
                File myObj = new File("myfile.txt");
                Scanner myReader = new Scanner(myObj);

                String sep2= "',";
                int sep4;
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();

                    sep4=data.indexOf(sep2);

                    vector.add(Double.parseDouble(data.substring(2,sep4)));


                    //System.out.println(vector);
                }
                myReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }


//            double nr = vector.get(5);

            stage.setTitle("Line Chart Sample");
            //defining the axes
            final NumberAxis xAxis = new NumberAxis();
            final NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel("Month day");
            //creating the chart
            final LineChart<Number,Number> lineChart =
                    new LineChart<Number,Number>(xAxis,yAxis);

            lineChart.setTitle("Temperature Monitoring, 2021");
            //defining a series
            XYChart.Series series = new XYChart.Series();
            XYChart.Series series1 = new XYChart.Series();
            series.setName("Temperature average per day");
            //populating the series with data
            int n=vector.size();
            int counter=0;
            for(int index=n-10; index<n; index++)
            {
                series.getData().add(new XYChart.Data(counter,vector.get(index)));
                counter++;
            }
            ///Below: Fake data
//            series.getData().add(new XYChart.Data(2, 20));
//            series.getData().add(new XYChart.Data(3, 21.4));
//            series.getData().add(new XYChart.Data(4, 19.7));
//            series.getData().add(new XYChart.Data(5, 20.2));
//            series.getData().add(new XYChart.Data(6, 21.9));
//            series.getData().add(new XYChart.Data(7, 21));
//            series.getData().add(new XYChart.Data(8, -3));
//            series.getData().add(new XYChart.Data(9, 17.1));
//            series.getData().add(new XYChart.Data(10, 17));
//            series.getData().add(new XYChart.Data(11, 19.4));
//            series.getData().add(new XYChart.Data(12, 21.1));

            Scene scene  = new Scene(lineChart,8000,6000);
            lineChart.getData().add(series);

            stage.setScene(scene);
            stage.show();

        }



    public static void main(String[] args) {
        launch(args);
    }
}
