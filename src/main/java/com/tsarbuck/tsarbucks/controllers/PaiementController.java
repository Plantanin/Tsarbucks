package com.tsarbuck.tsarbucks.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PaiementController {

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

    final private float price = 8.30F;
    private float amount = 0.0F;

    @FXML
    public void initialize() {
        twoEurosButton.setOnAction(event -> ajouterMontant(2.0));
        oneEuroButton.setOnAction(event -> ajouterMontant(1.0));
        fiftyCentsButton.setOnAction(event ->ajouterMontant(0.5));
        tenCentsButton.setOnAction(event ->ajouterMontant(0.1));
    }

    private void ajouterMontant(float actuallAmount) {

        amount += actuallAmount;
        updateView();
        verifyPayment();
    }

    private void verifyPayment() {
        if (amount == price) {
            redirectToConfirmationPage();
        } else if(amount > price) {
            float overflow = actuallAmount - price;
            redirectToOverflowPage();
        } else {
            statePaymentLabel.setText(String.format("Il manque encore : %.2f €", price - actuallAmount));
        }
    }
}
