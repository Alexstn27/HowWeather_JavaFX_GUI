package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        ReadFile xy = new ReadFile();
        xy.read();
        ChartClass chartClass = new ChartClass();

        //preparing the options menu
        primaryStage.setTitle("Menu");
        MenuItem menuItem1 = new MenuItem("Temperature");
        MenuItem menuItem2 = new MenuItem("Light");
        MenuItem menuItem3 = new MenuItem("Pressure");

        //adding the logo
        FileInputStream inputStream = new FileInputStream("GUI_image1.jpeg");
        Image image = new Image(inputStream);
        ImageView imageView = new ImageView(image);

        //creating the buttons and set the action when a button is pressed

        MenuButton menuButton = new MenuButton("Options", null, menuItem1, menuItem2, menuItem3);
        Font font = Font.font("Courier New", FontWeight.BLACK, 36);
        menuButton.setFont(font);
        HBox hBox = new HBox(menuButton);
        menuButton.setGraphic(imageView);

        Scene scene = new Scene(hBox, 502, 240);
        primaryStage.setScene(scene);
        primaryStage.show();

        menuItem1.setOnAction(actionEvent -> chartClass.makeChart((ArrayList<Double>) xy.getTemperatureVector()));

        menuItem2.setOnAction(actionEvent -> chartClass.makeChart((ArrayList<Double>) xy.getLightVector()));

        menuItem3.setOnAction(actionEvent -> chartClass.makeChart((ArrayList<Double>) xy.getPressureVector()));

    }

}
