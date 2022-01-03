package com.example.currencycalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CurrencyCalculator extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CurrencyCalculator.class.getResource("hello-view.fxml"));
        Scene insideofstage = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Currency Calculator");
        stage.setScene(insideofstage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}