package com.tsarbuck.tsarbucks.controllers;

import com.tsarbuck.tsarbucks.models.Commande;
import com.tsarbuck.tsarbucks.models.Taille;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class BoissonSelectController {

    @FXML
    private Text labelNomBoisson;

    @FXML
    private Label labelTaille;

    private Commande commande;

    public void setCommande(Commande commande) {
        this.commande = commande;
        updateBoissonView();
    }

    @FXML
    private void handleValider() {
        System.out.println("Commande validée : " + commande);
        // Ici tu peux passer à une autre vue (paiement par ex.)
    }

    @FXML
    private void setCommandeTailleM() {
        commande.setTaille(Taille.MOYEN);
        commande.setPrix(commande.getBoisson().getPrixM());
        System.out.println(commande.getTaille());
    }

    @FXML
    private void setCommandeTailleL() {
        commande.setTaille(Taille.GRAND);
        commande.setPrix(commande.getBoisson().getPrixL());
        System.out.println(commande.getTaille());
    }

    @FXML
    private void goToNextScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/payment.fxml"));
            Parent root = loader.load();

            PaymentController controller = loader.getController();
            controller.setCommandePayment(commande);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 400, 700));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToPreviousScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ChoixBoisson.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 400, 700));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void updateBoissonView() {
        if (commande != null && commande.getBoisson() != null) {
            labelNomBoisson.setText("Caffé " + commande.getBoisson().getName());
        }
    }
}
