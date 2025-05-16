package com.tsarbuck.tsarbucks.models;

public class Boisson {

    private String name;
    private int prixM;
    private int prixL;

    public Boisson(String name, int prixM, int prixL) {
        this.name = name;
        this.prixL = prixL;
        this.prixM = prixM;
    }

    public String getName() {
        return name;
    }

    public int getPrixM() {
        return prixM;
    }

    public int getPrixL() {
        return prixL;
    }

    public void setPrixL(int prixL) {
        this.prixL = prixL;
    }

    public void setPrixM(int prixM) {
        this.prixM = prixM;
    }

    public void setName(String name) {
        this.name = name;
    }
}
