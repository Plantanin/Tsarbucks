package com.tsarbuck.tsarbucks;

import com.tsarbuck.tsarbucks.controllers.PaymentController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Charge le FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/payment.fxml"));
            Parent root = loader.load();

            // Récupère le contrôleur
            PaymentController controller = loader.getController();


            // Prépare et affiche la scène
            Scene scene = new Scene(root);
            primaryStage.setTitle("Confirmation de paiement");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Lancement de l'application
    public static void main(String[] args) {
        launch(args);
    }
}
