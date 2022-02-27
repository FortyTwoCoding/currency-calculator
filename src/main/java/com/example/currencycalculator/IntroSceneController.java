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

        String currency1 = textAbbreviation1.getText();
        String currency2 = textAbbreviation2.getText();
        CurrencyCalculator.base1 = currency1;
        CurrencyCalculator.base2 = currency2;
        GetPriceClass obj1 = GetPriceClass.getvalue(currency1);
        GetPriceClass obj2 = GetPriceClass.getvalue(currency2);
        double value1 = obj1.price;
        currency1 = obj1.name;
        currency2 = obj2.name;
        double value2 = obj2.price;
        double exchangerate = value1/value2;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("graphsc2.fxml"));
        Parent root = fxmlLoader.load();

        InfoSceneController infoSceneController = fxmlLoader.getController();
        infoSceneController.exchangeratelabel(currency1, currency2, exchangerate);
        infoSceneController.columncurrency1.setText("FIAT");
        infoSceneController.columncurrency2.setText("FIAT");
        infoSceneController.currency1inFIAT.setText("Value");
        infoSceneController.currency2inFIAT.setText("Value");
        infoSceneController.leftfiattableheader.setText(currency1 +" in FIAT");
        infoSceneController.rightfiattableheader.setText(currency2+" in FIAT");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
