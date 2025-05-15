package com.tsarbuck.tsarbucks.controllers;

import javafx.fxml.FXML;
<<<<<<< HEAD
import javafx.scene.layout.BorderPane;

public class LaunchController {
    @FXML
    private BorderPane rootPane; // <- FX ID de ton BorderPane racine

    @FXML
    public void initialize() {
        rootPane.setOnMouseClicked(event -> {
            NavigationController.switchScene("next_view.fxml", event);
        });
=======
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LaunchController {

    @FXML
    private Button launchButton;

    @FXML
    private void goToMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menu-order.fxml"));
            Stage stage = (Stage) launchButton.getScene().getWindow();
            stage.setScene(new Scene(loader.load(), 600, 400));
        } catch (IOException e) {
            e.printStackTrace();
        }
>>>>>>> e71451b (creation de la commande)
    }
}
