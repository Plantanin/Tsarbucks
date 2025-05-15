package com.tsarbuck.tsarbucks.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Parent;

import java.io.IOException;

import com.tsarbuck.tsarbucks.controllers.CommandeController;

public class MenuController {

    private void goToOrder(String coffeeName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/order-view.fxml"));
            Parent root = loader.load();

            CommandeController controller = loader.getController();
            controller.setCoffeeName(coffeeName);



            Stage stage = (Stage) ((Button) root.lookup(".button")).getScene().getWindow();
            stage.setScene(new Scene(root, 600, 400));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void orderEspresso() {
        goToOrder("Espresso");
    }

    @FXML
    private void orderLatte() {
        goToOrder("Latte");
    }

    @FXML
    private void orderCappuccino() {
        goToOrder("Cappuccino");
    }

    @FXML
    private void goToLaunch() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/launch-view.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 600, 400));
            stage.show();
            Stage current = (Stage) ((Button) loader.getNamespace().get("goToLaunch")).getScene().getWindow();
            current.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
