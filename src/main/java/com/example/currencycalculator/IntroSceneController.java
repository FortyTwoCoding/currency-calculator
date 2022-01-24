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

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void buttonclicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("graphsc2.fxml"));
        root = fxmlLoader.load();

        InfoSceneController infoSceneController = fxmlLoader.getController();

        String currency1 = textAbbreviation1.getText();
        String currency2 = textAbbreviation2.getText();
        double value1 = main.getvalue(currency1);
        double value2 = main.getvalue(currency2);
        System.out.println(currency1+": "+value1+ currency2+": "+value2);
        double exchangerate = value2/value1;
        infoSceneController.exchangeratelabel(currency1, currency2, exchangerate);

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
