package com.example.currencycalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
                try {
                    FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("graphsc2.fxml"));
                    Parent root2 = fxmlLoader2.load();

                    InfoSceneController infoSceneController = fxmlLoader2.getController();

                    String currency1 = controller.textAbbreviation1.getText();
                    String currency2 = controller.textAbbreviation2.getText();
                    GetPriceClass obj1 = GetPriceClass.getvalue(currency1);
                    double value1 = obj1.price;
                    currency1 = obj1.name;
                    obj1 = GetPriceClass.getvalue(currency2);
                    currency2 = obj1.name;
                    double value2 = obj1.price;
                    double exchangerate = value1 / value2;
                    infoSceneController.exchangeratelabel(currency1, currency2, exchangerate);

                    Scene scene = new Scene(root2);
                    stage.setScene(scene);
                    stage.show();
                }
                catch (IOException e){
                    e.printStackTrace();
                }

            }
        });
    }
//launch method eventually initiates the start method => creates a window
    public static void main(String[] args) {
            launch(args);
    }
}