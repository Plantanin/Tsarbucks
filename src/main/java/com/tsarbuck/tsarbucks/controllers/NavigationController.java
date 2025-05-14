package com.tsarbuck.tsarbucks.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class NavigationController {
    public static void switchScene(String fxmlFile, ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loadScene(stage, fxmlFile);
    }

    public static void switchScene(String fxmlFile, MouseEvent event) {
        System.out.println("next scene");
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        loadScene(stage, fxmlFile);
    }

    private static void loadScene(Stage stage, String fxmlFile) {
        try {
            Parent root = FXMLLoader.load(NavigationController.class.getResource("/views/" + fxmlFile));
            stage.setScene(new Scene(root, 400, 300));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
