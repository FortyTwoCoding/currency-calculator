package com.example.currencycalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class IntroSceneController {
    @FXML
    Button goButton;
    @FXML
    TextField textAbbreviation;


    public void buttonclicked(ActionEvent event) {
        System.out.println("button was clicked.");
    }
}
