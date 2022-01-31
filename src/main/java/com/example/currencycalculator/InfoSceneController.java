package com.example.currencycalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class InfoSceneController {
    @FXML
    Label exchangeRate;
    @FXML
    TableView<Currency> c1table;
    @FXML
    TableView<Currency> c2table;
    @FXML
    TableColumn<Currency, String> columncurrency1;
    @FXML
    TableColumn<Currency, Double> currency1inFIAT;
    @FXML
    TableColumn<Currency, String> columncurrency2;
    @FXML
    TableColumn<Currency, Double> currency2inFIAT;

    public void exchangeratelabel(String currency1, String currency2, double exchangerate) throws IOException {
        exchangeRate.setText("1"+currency1+" = "+exchangerate+" "+currency2);
    }

}
