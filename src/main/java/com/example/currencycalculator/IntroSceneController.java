package com.example.currencycalculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class IntroSceneController {
    @FXML
    public Button goButton;
    @FXML
    public TextField textAbbreviation;


    public void buttonclicked(ActionEvent event) throws IOException {
        String text = textAbbreviation.getText();
        double value = main.getvalue(text);
        System.out.println(value);
    }
}
