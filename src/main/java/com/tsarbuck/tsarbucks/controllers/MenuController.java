package com.tsarbuck.tsarbucks.controllers;

import com.tsarbuck.tsarbucks.models.Boisson;
import com.tsarbuck.tsarbucks.models.Commande;
import com.tsarbuck.tsarbucks.models.Taille;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Parent;

import java.io.IOException;

public class MenuController {

    private Boisson expresso;
    private Boisson latte;
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


    private void showBoissonSelection(String nomBoisson) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ChoixBoisson.fxml"));
            //loader.setController(this);

            Parent root = loader.load();

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
    }


    @FXML
    private void handleAjouterEspresso(ActionEvent event) {
        showBoissonSelection("Espresso");
        commande = new Commande(expresso);
        System.out.println(this.commande);
        goToNextScene(event);
    }

    @FXML
    private void handleAjouterLatte(ActionEvent event) {
        //NavigationController.switchScene("BoissonSelec.fxml", event);
        showBoissonSelection("Latte");
        commande = new Commande(latte);
        System.out.println(commande);
        goToNextScene(event);
    }

    @FXML
    private void handleAjouterCappuccino(ActionEvent event) {
        showBoissonSelection("Cappuccino");
        goToNextScene(event);
    }

    @FXML
    private void setCommandeTailleM() {
        commande.setTaille(Taille.MOYEN);
        System.out.println(commande);
    }

    @FXML
    private void goToNextScene(ActionEvent event) {
        NavigationController.switchScene("BoissonSelec.fxml", event);
    }

}
