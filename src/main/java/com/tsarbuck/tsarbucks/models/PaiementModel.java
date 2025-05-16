package com.tsarbuck.tsarbucks.models;

public class PaiementModel {

    private int id;
    private float moneyQuantity;

    public PaiementModel(int id, float moneyQuantity) {
        this.id = id;
        this.moneyQuantity = moneyQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMoneyQuantity() {
        return moneyQuantity;
    }

    public void setMoneyQuantity(float moneyQuantity) {
        this.moneyQuantity = moneyQuantity;
    }

    // Calcul du reste à rendre
    public float moneyGaveBack(float price) {
        return (moneyQuantity > price) ? (moneyQuantity - price) : (float) 0.0;
    }
}
