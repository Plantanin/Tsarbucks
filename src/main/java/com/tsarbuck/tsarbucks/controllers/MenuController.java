package com.tsarbuck.tsarbucks.controllers;

import com.tsarbuck.tsarbucks.models.Boisson;
import com.tsarbuck.tsarbucks.models.Commande;
import com.tsarbuck.tsarbucks.models.Taille;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    private Boisson expresso;
    private Boisson latte;
    private Boisson cappuccino;
    private Commande commande;


    @FXML
    private Button btnTailleM;

    @FXML
    private Button btnTailleL;


    @FXML
    private Slider sliderSucre;


    @FXML
    private Slider sliderLait;

    @FXML
    private Button btnAjouterLatte;

    @FXML
    private Button btnRetirerLatte;

    @FXML
    private Button btnAjouterEspresso;

    @FXML
    private Button btnRetirerEspresso;

    @FXML
    private Button btnAjouterCapuccino;

    @FXML
    private Button btnRetirerCapuccino;


    @FXML
    private Label labelNomBoisson;

    @FXML
    private Label labelSucreBoisson;

    @FXML
    private Label labelLaitBoisson;


    private void showBoissonSelection(String nomBoisson, Commande commande) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ChoixBoisson.fxml"));
            //loader.setController(this);

            Parent root = loader.load();

            BoissonSelectController controller = loader.getController();
            controller.setCommande(commande);

            // Récupère les quantités actuelles
//            int sucre = (int) sliderSucre.getValue();
//            int lait = (int) sliderLait.getValue();

            // Met à jour les labels dans la vue boisson selec
            labelNomBoisson = (Label) root.lookup("#labelNomBoisson");
            labelSucreBoisson = (Label) root.lookup("#labelSucreBoisson");
            labelLaitBoisson = (Label) root.lookup("#labelLaitBoisson");

            if (labelNomBoisson != null) labelNomBoisson.setText("Boisson : " + nomBoisson);
//            if (labelSucreBoisson != null) labelSucreBoisson.setText("Sucre : " + sucre);
//            if (labelLaitBoisson != null) labelLaitBoisson.setText("Lait : " + lait);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        expresso = new Boisson("expresso", 10, 15);
        latte = new Boisson("latte", 11, 14);
        cappuccino = new Boisson("cappuccino", 12, 15);
    }


    @FXML
    private void handleAjouterExpresso(MouseEvent event) {
        commande = new Commande(expresso);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/BoissonSelec.fxml"));
            Parent root = loader.load();

            // ✅ Récupération du contrôleur et passage de la commande
            BoissonSelectController controller = loader.getController();
            controller.setCommande(commande);

            System.out.println(commande);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 400, 700));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAjouterLatte(MouseEvent event) {
        //NavigationController.switchScene("BoissonSelec.fxml", event);
        commande = new Commande(latte);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/BoissonSelec.fxml"));
            Parent root = loader.load();

            // ✅ Récupération du contrôleur et passage de la commande
            BoissonSelectController controller = loader.getController();
            controller.setCommande(commande);

            System.out.println(commande.getBoisson().getName());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 400, 700));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAjouterCappuccino(MouseEvent event) {
        commande = new Commande(cappuccino);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/BoissonSelec.fxml"));
            Parent root = loader.load();

            // ✅ Récupération du contrôleur et passage de la commande
            BoissonSelectController controller = loader.getController();
            controller.setCommande(commande);

            System.out.println(commande);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 400, 700));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToNextScene(ActionEvent event) {
        NavigationController.switchScene("BoissonSelec.fxml", event);
    }

    @FXML
    private void goToLaunch(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Launch_Hs.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 400, 700));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
