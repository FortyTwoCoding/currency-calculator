package com.example.currencycalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;
//Override of the start method from the Application class
public class CurrencyCalculator extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //create an fxmlLoader object with the fxml information of the intro scene
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("graphsc1.fxml"));
        //create a root node for the scene, create scene
        Parent root = fxmlLoader.load();
        Scene insideofstage = new Scene(root);
        //set title and icon of the window
        stage.setTitle("Currency Calculator");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("dogeicon.png")));
        //create a controller object of the IntroSceneController class to pass information between the controllers
        IntroSceneController controller = fxmlLoader.getController();
        //"make the window"
        stage.setScene(insideofstage);
        stage.show();
        //KeyEventHandler when Enter is pressed in IntroScene
        insideofstage.setOnKeyPressed(keyEvent -> {

            if (keyEvent.getCode() == KeyCode.ENTER) {
                String text = controller.textAbbreviation1.getText();
                double value;
                try {
                    value = GetPriceClass.getvalue(text);
                } catch (Exception e) {
                    value = 0.0;
                }
                System.out.println(value);

            }
        });
    }
//launch method eventually initiates the start method => creates a window
    public static void main(String[] args) {
            launch(args);
    }
}