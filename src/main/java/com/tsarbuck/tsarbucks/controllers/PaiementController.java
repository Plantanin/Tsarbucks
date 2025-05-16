package com.tsarbuck.tsarbucks.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PaiementController {

    // Déclaration des boutons
    @FXML
    private Button cardPaymentBtn;
    @FXML
    private Button twoEurosButton;
    @FXML
    private Button oneEuroButton;
    @FXML
    private Button fiftyCentsButton;
    @FXML
    private Button tenCentsButton;

    // Label pour afficher le montant actuel inséré
    @FXML
    private Label montantActuelLabel;
    // Label pour afficher le message de statut de paiement
    @FXML
    private Label statePaymentLabel;

    // Prix fixe à payer
    private final float price = 8.30F;
    // Montant inséré par l'utilisateur
    private float amount = 0.0F;

    @FXML
    public void initialize() {
        // Initialisation des boutons
        twoEurosButton.setOnAction(event -> ajouterMontant(2.0F));
        oneEuroButton.setOnAction(event -> ajouterMontant(1.0F));
        fiftyCentsButton.setOnAction(event -> ajouterMontant(0.5F));
        tenCentsButton.setOnAction(event -> ajouterMontant(0.1F));
        cardPaymentBtn.setOnAction(event -> ajouterMontant(price));

        updateView();
        verifyPayment();
    }

    private void ajouterMontant(float addedAmount) {
        amount += addedAmount;
        updateView();
        verifyPayment();
    }

    private void updateView() {
        montantActuelLabel.setText(String.format("Montant: %.2f €", amount));
    }

    private void verifyPayment() {
        if (amount == price) {
            statePaymentLabel.setText("Paiement exact !");
            redirectPageConfirmation();
        } else if (amount > price) {
            float overflow = amount - price;
            statePaymentLabel.setText(String.format("Paiement en trop : %.2f € à rendre.", overflow));
            redirectPageRenduMonnaie(overflow);
        } else {
            statePaymentLabel.setText(String.format("Il manque encore : %.2f €", price - amount));
        }
    }

    private void redirectPageConfirmation() {
        System.out.println("Redirection vers la page de confirmation...");
        // FXMLLoader.load(getClass().getResource("/com/tsarbuck/tsarbucks/views/Confirmation.fxml"));
    }

    private void redirectPageRenduMonnaie(double montantARendre) {
        System.out.println("Redirection vers la page de rendu avec " + montantARendre + "€ à rendre...");
        // FXMLLoader.load(getClass().getResource("/com/tsarbuck/tsarbucks/views/RenduMonnaie.fxml"));
    }
}
