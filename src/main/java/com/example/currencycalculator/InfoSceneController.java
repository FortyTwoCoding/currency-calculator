package com.example.currencycalculator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InfoSceneController implements Initializable {
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

    ObservableList<Currency> list = FXCollections.observableArrayList(
            new Currency("btc", 42,42,4,42)
    );
    @Override
    public void initialize(URL url, ResourceBundle rb){
        columncurrency1.setCellValueFactory(new PropertyValueFactory<Currency, String>("name"));
        currency1inFIAT.setCellValueFactory(new PropertyValueFactory<Currency, Double>("price"));
        columncurrency2.setCellValueFactory(new PropertyValueFactory<Currency, String>("name"));
        currency2inFIAT.setCellValueFactory(new PropertyValueFactory<Currency, Double>("price"));

        c1table.setItems(list);

    }
    public void exchangeratelabel(String currency1, String currency2, double exchangerate) throws IOException {
        exchangeRate.setText("1"+currency1+" = "+exchangerate+" "+currency2);
    }

}
