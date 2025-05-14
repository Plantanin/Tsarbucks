package com.tsarbuck.tsarbucks.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class LaunchController {
    @FXML
    private BorderPane rootPane; // <- FX ID de ton BorderPane racine

    @FXML
    public void initialize() {
        rootPane.setOnMouseClicked(event -> {
            NavigationController.switchScene("next_view.fxml", event);
        });
    }
}
