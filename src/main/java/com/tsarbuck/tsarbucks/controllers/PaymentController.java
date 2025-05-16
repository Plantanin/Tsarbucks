package com.tsarbuck.tsarbucks.controllers;

import com.tsarbuck.tsarbucks.models.Commande;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class PaymentController {

    // Déclaration des boutons
    @FXML
    private VBox paymentButtons;

    @FXML
    private Button cardPaymentBtn;
    @FXML
    private Button cardPaymentFailedBtn;
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
        cardPaymentBtn.setOnAction(event -> ajouterMontant(commande.getPrix()));
        cardPaymentFailedBtn.setOnAction(event -> failedPayment());
        checkImage = new Image(getClass().getResourceAsStream("/images/check_icon.png"));
        xImage = new Image(getClass().getResourceAsStream("/images/x_icon.png"));
        arrowDownImage = new Image(getClass().getResourceAsStream("/images/arrow_down_icon.png"));
        messageLabel.setText("Insérez carte ou espèces");

        // Masquer l'image par défaut
        hideImage();

        // Afficher le prix transmis (si défini avant affichage)
        

        // Masquer la monnaie restante
        hideMoneyLeft();
    }

    public void setCommandePayment(Commande commande) {
        this.commande = commande;
        verifyPayment();
        setPrice();
        System.out.println("paiment: " + commande.getPrix());
    }

    private void ajouterMontant(float addedAmount) {
        amount += addedAmount;
        verifyPayment();
    }

    private void verifyPayment() {
        setPrice();
        hideImage();
        messageLabel.setText("Insérez carte ou espèces");
        showButtons();
        if (amount == commande.getPrix()) {
            messageLabel.setText("Merci pour votre achat !");
            setImage(checkImage);
            hidePrice();
            hideButtons();
            redirectPageConfirmation();
        } else if (amount > commande.getPrix()) {
            float overflow = amount - commande.getPrix();
            messageLabel.setText(String.format("Récupérez votre monnaie"));
            showMoneyLeft(overflow);
            setImage(arrowDownImage);
            hidePrice();
            hideButtons();
            redirectPageRenduMonnaie(overflow);
        } else if (amount < commande.getPrix()) {
            messageLabel.setText(String.format("Il manque encore : %.2f €", commande.getPrix() - amount));
        } else {
            messageLabel.setText(String.format("Opération échouée"));
            setImage(xImage);
            hideButtons();
            hidePrice();
        }
    }

    public void failedPayment() {
        messageLabel.setText("Opération échouée");
        setImage(xImage);
        hidePrice();
        hideButtons();

        // Attendre 5 secondes puis relancer verifyPayment
        PauseTransition pause = new PauseTransition(Duration.seconds(5));
        pause.setOnFinished(event -> verifyPayment());
        pause.play();
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

    public void setPrice() {
        System.out.println("getPrice: " + commande);
        beveragePrice.setText(String.format("%.2f €", commande.getPrix()));
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

    public void showButtons() {
        paymentButtons.setVisible(true);
        paymentButtons.setManaged(true);
    }

    public void hideButtons() {
        paymentButtons.setVisible(false);
        paymentButtons.setManaged(false);
    }
}
