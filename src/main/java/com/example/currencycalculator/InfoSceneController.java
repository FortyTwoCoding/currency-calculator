package com.example.currencycalculator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
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
    //TODO base should be input
    GetPriceClass getPriceClass = new GetPriceClass("eth");

    Map<String,Double> map = GetPriceClass.getcurrency("usd");


    //TODO fix
    ObservableList<Currency> list = FXCollections.observableArrayList(
            new Currency("", map.get("USD"),map.get("CHF") , map.get("JPY"),map.get("CNY"))
    );
    ObservableList<Currency> list2 = FXCollections.observableArrayList(
            new Currency("",map.get("USD"),map.get("CHF"),map.get("JPY"),map.get("CNY"))
    );

    @Override
    public void initialize(URL url, ResourceBundle rb){
        columncurrency1.setCellValueFactory(new PropertyValueFactory<Currency, String>("name"));
        currency1inFIAT.setCellValueFactory(new PropertyValueFactory<Currency, Double>("usd"));
        columncurrency2.setCellValueFactory(new PropertyValueFactory<Currency, String>("name"));
        currency2inFIAT.setCellValueFactory(new PropertyValueFactory<Currency, Double>("usd"));
        c1table.setItems(list);
        c2table.setItems(list2);

    }
    public void exchangeratelabel(String currency1, String currency2, double exchangerate) throws IOException {
        exchangeRate.setText("1 "+currency1+" = "+exchangerate+" "+currency2);
    }


}
