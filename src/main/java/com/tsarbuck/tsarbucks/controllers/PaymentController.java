package com.tsarbuck.tsarbucks.controllers;

import com.tsarbuck.tsarbucks.models.Commande;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class PaymentController {

    // Déclaration des boutons
    @FXML
    private VBox paymentButtons;

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

    @FXML
    private Label messageLabel;

    @FXML
    private ImageView checkIcon;

    @FXML
    private Label beveragePrice;

    @FXML
    private Commande commande;

    @FXML
    private Label moneyLeft;

    // Prix fixe à payer
    private final float price = 8.30F;
    // Montant inséré par l'utilisateur
    private float amount = 0.0F;

    private Image checkImage;
    private Image xImage;
    private Image arrowDownImage;

    @FXML
    public void initialize() {
        // Initialisation des boutons
        twoEurosButton.setOnAction(event -> ajouterMontant(2.0F));
        oneEuroButton.setOnAction(event -> ajouterMontant(1.0F));
        fiftyCentsButton.setOnAction(event -> ajouterMontant(0.5F));
        tenCentsButton.setOnAction(event -> ajouterMontant(0.1F));
        cardPaymentBtn.setOnAction(event -> ajouterMontant(price));
        checkImage = new Image(getClass().getResourceAsStream("/images/check_icon.png"));
        xImage = new Image(getClass().getResourceAsStream("/images/x_icon.png"));
        arrowDownImage = new Image(getClass().getResourceAsStream("/images/arrow_down_icon.png"));

        verifyPayment();

        messageLabel.setText("Insérez carte ou espèces");

        // Masquer l'image par défaut
        hideImage();

        // Afficher le prix transmis (si défini avant affichage)
        setPrice(price);

        // Masquer la monnaie restante
        hideMoneyLeft();
    }

    public void setCommandePayment(Commande commande) {
        this.commande = commande;
        System.out.println("paiment: " + commande.getPrix());
    }

    private void ajouterMontant(float addedAmount) {
        amount += addedAmount;
        verifyPayment();
    }

    private void verifyPayment() {
        if (amount == price) {
            messageLabel.setText("Merci pour votre achat !");
            setImage(checkImage);
            hidePrice();
            hideButtons();
            redirectPageConfirmation();
        } else if (amount > price) {
            float overflow = amount - price;
            messageLabel.setText(String.format("Récupérez votre monnaie"));
            showMoneyLeft(overflow);
            setImage(arrowDownImage);
            hidePrice();
            hideButtons();
            redirectPageRenduMonnaie(overflow);
        } else if (amount < price) {
            messageLabel.setText(String.format("Il manque encore : %.2f €", price - amount));
        } else {
            messageLabel.setText(String.format("Opération échouée"));
            setImage(xImage);
            hideButtons();
            hidePrice();
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

    public void setPrice(float price) {
        beveragePrice.setText(String.format("%.2f €", price));
        beveragePrice.setVisible(true);
        beveragePrice.setManaged(true);
    }

    public void hidePrice() {
        beveragePrice.setVisible(false);
        beveragePrice.setManaged(false);
    }

    public void showMoneyLeft(float amount) {
        moneyLeft.setText(String.format("%.2f €", amount));
        moneyLeft.setVisible(true);
        moneyLeft.setManaged(true);
    }

    public void hideMoneyLeft() {
        moneyLeft.setVisible(false);
        moneyLeft.setManaged(false);
    }

    public void hideButtons() {
        paymentButtons.setVisible(false);
        paymentButtons.setManaged(false);
    }
}
