package com.example.currencycalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class IntroSceneController {
    @FXML
    Button goButton;
    @FXML
    TextField textAbbreviation;


    public void buttonclicked(ActionEvent event) throws IOException {
        String text = textAbbreviation.getText();
        double value = main.getvalue(text);
        System.out.println(value);
    }
}
