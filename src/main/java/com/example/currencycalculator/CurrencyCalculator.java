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
    public static String base1;
    public static String base2;
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


                    String currency1 = controller.textAbbreviation1.getText();
                    String currency2 = controller.textAbbreviation2.getText();
                    CurrencyCalculator.base1 = currency1;
                    CurrencyCalculator.base2 = currency2;
                    GetPriceClass obj1 = GetPriceClass.getvalue(currency1);
                    GetPriceClass obj2 = GetPriceClass.getvalue(currency2);
                    double value1 = obj1.price;
                    currency1 = obj1.name;
                    currency2 = obj2.name;
                    double value2 = obj2.price;
                    double exchangerate = value1/value2;
                    FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("graphsc2.fxml"));
                    Parent root2 = fxmlLoader2.load();

                    InfoSceneController infoSceneController = fxmlLoader2.getController();
                    infoSceneController.exchangeratelabel(currency1, currency2, exchangerate);
                    infoSceneController.columncurrency1.setText("FIAT");
                    infoSceneController.columncurrency2.setText("FIAT");
                    infoSceneController.currency1inFIAT.setText("Value");
                    infoSceneController.currency2inFIAT.setText("Value");
                    infoSceneController.leftfiattableheader.setText(currency1 +" in FIAT");
                    infoSceneController.rightfiattableheader.setText(currency2+" in FIAT");
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