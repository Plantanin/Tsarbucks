package com.tsarbuck.tsarbucks.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CommandeController {

    @FXML
    private Label coffeeNameLabel;

    @FXML
    private Button goBackButton;

    @FXML
    private Button buyButton;

    public void setCoffeeName(String name) {
        coffeeNameLabel.setText("Votre commande : " + name);
    }

    @FXML
    private void goToLaunch() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/launch_Hs.fxml"));  // Corrige ici si nécessaire le nom exact de ton fichier FXML
            Stage stage = (Stage) coffeeNameLabel.getScene().getWindow();
            stage.setScene(new Scene(loader.load(), 600, 400));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToPayment() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/payment-view.fxml"));
            Stage stage = (Stage) buyButton.getScene().getWindow();
            stage.setScene(new Scene(loader.load(), 600, 400));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
