package com.tsarbuck.tsarbucks.models;

import java.util.Date;

public class Commande {

    private Date date;
    private float prix;
    private Enum taille;
    private boolean supplement;
    private State state;
    private Boisson boisson;

    public Commande(Boisson boisson){
        this.boisson = boisson;
    }

    public Commande(Boisson boisson, Date date, float prix, Enum taille, boolean supplement, State state) {
        this.date = date;
        this.prix = prix;
        this.taille = taille;
        this.supplement = supplement;
        this.state = state;
        this.boisson = boisson;
    }

    public Boisson getBoisson() {
        return boisson;
    }

    public void setBoisson(Boisson boisson) {
        this.boisson = boisson;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setTaille(Enum taille) {
        this.taille = taille;
    }
    public Enum getTaille() {
        return taille;
    }


    public boolean isSupplement() {
        return supplement;
    }

    public void setSupplement(boolean supplement) {
        this.supplement = supplement;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
