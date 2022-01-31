package com.example.currencycalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class IntroSceneController {
    @FXML
    public Button goButton;
    @FXML
    public TextField textAbbreviation1;
    @FXML
    public TextField textAbbreviation2;

    public void buttonclicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("graphsc2.fxml"));
        Parent root = fxmlLoader.load();

        InfoSceneController infoSceneController = fxmlLoader.getController();

        String currency1 = textAbbreviation1.getText();
        String currency2 = textAbbreviation2.getText();
        GetPriceClass obj1 = GetPriceClass.getvalue(currency1);
        double value1 = obj1.price;
        currency1 = obj1.name;
        obj1 = GetPriceClass.getvalue(currency2);
        currency2 = obj1.name;
        double value2 = obj1.price;
        double exchangerate = value1/value2;
        infoSceneController.exchangeratelabel(currency1, currency2, exchangerate);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
