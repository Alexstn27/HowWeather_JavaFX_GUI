package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;

public class testclass extends Application {
    @Override
    public void start(Stage primarystage) throws IOException, FontFormatException {
//        ReadFile xy = new ReadFile();
//        xy.Read();

        primarystage.setTitle("Menu");
        MenuItem menuItem1 = new MenuItem("Temperature");
        MenuItem menuItem2 = new MenuItem("Light");
        MenuItem menuItem3 = new MenuItem("Pressure");
        FileInputStream inputStream= new FileInputStream("GUI_image1.jpeg");

        Image image= new Image(inputStream);
        ImageView imageView = new ImageView(image);

        MenuButton menuButton = new MenuButton("Options", null, menuItem1 , menuItem2 , menuItem3);
        Font font = Font.font("Courier New", FontWeight.BLACK, 36);
        menuButton.setFont(font);
        HBox hBox = new HBox(menuButton);
        menuButton.setGraphic(imageView);

        Scene scene = new Scene(hBox,502,240);
        primarystage.setScene(scene);
        primarystage.show();

        menuItem1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TemperatureGraph temperatureGraph = new TemperatureGraph();
                temperatureGraph.temperatureGraph();
            }
        });

        menuItem2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                LightGraph lightGraph = new LightGraph();
                lightGraph.lightGraph();
            }
        });

        menuItem3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                PressureGraph pressureGraph = new PressureGraph();
                pressureGraph.pressureGraph();
            }
        });


    }

}
