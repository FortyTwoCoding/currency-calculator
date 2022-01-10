package com.example.currencycalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class CurrencyCalculator extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CurrencyCalculator.class.getResource("graphsc1.fxml"));
        Parent root = fxmlLoader.load();
        Scene insideofstage = new Scene(root);
        stage.setTitle("Currency Calculator");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("dogeicon.png")));
        stage.setScene(insideofstage);
        stage.show();
    }

    public static void main(String[] args) {
        try {
            launch(args);
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }
}