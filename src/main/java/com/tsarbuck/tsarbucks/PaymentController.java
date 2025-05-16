package com.tsarbuck.tsarbucks;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PaymentController {

    @FXML
    private Label messageLabel;

    @FXML
    private ImageView checkIcon;

    @FXML
    private Label beveragePrice;

    @FXML
    private Label moneyLeft;

    // Valeur du prix à initialiser depuis le main
    private double price = 4.0;
    private double amount = 8.0;

    // Appelé automatiquement après chargement du FXML
    @FXML
    public void initialize() {
        // Message par défaut
        messageLabel.setText("Insérez carte ou espèces");

        // Masquer l'image par défaut
        hideImage();

        // Afficher le prix transmis (si défini avant affichage)
        setPrice(price);

        // Masquer la monnaie restante
        hideMoneyLeft();
    }

    // Méthode pour définir dynamiquement le message
    public void setMessage(String message) {
        messageLabel.setText(message);
    }

    // Méthode pour définir dynamiquement l’image
    public void setImage(Image image) {
        checkIcon.setImage(image);
        checkIcon.setVisible(true);
        checkIcon.setManaged(true);
    }

    public void hideImage() {
        checkIcon.setVisible(false);
        checkIcon.setManaged(false);
    }

    public void setPrice(double price) {
        beveragePrice.setText(String.format("%.2f €", price));
        beveragePrice.setVisible(true);
        beveragePrice.setManaged(true);
    }

    public void hidePrice() {
        beveragePrice.setVisible(false);
        beveragePrice.setManaged(false);
    }

    public void showMoneyLeft(double amount) {
        moneyLeft.setText(String.format("%.2f €", amount));
        moneyLeft.setVisible(true);
        moneyLeft.setManaged(true);
    }

    public void hideMoneyLeft() {
        moneyLeft.setVisible(false);
        moneyLeft.setManaged(false);
    }
}
