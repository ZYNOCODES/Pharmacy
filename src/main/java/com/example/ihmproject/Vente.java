package com.example.ihmproject;

public class Vente {
    private int med_Quantity;
    private String med_Name;
    private int med_Total;
    private int med_Price;
    private int med_ID;
    private int VenteNumber;

    public Vente() {
    }

    public Vente(int med_ID, int med_Quantity, String med_Name, int med_Total, int med_Price) {
        this.med_ID = med_ID;
        this.med_Quantity = med_Quantity;
        this.med_Name = med_Name;
        this.med_Total = med_Total;
        this.med_Price = med_Price;
    }

    public Vente(int med_ID, int VenteNumber, int med_Quantity, String med_Name, int med_Total, int med_Price) {
        this.med_Quantity = med_Quantity;
        this.med_Name = med_Name;
        this.med_Total = med_Total;
        this.med_Price = med_Price;
        this.med_ID = med_ID;
        this.VenteNumber = VenteNumber;
    }

    public int getMed_ID() {
        return med_ID;
    }

    public void setMed_ID(int med_ID) {
        this.med_ID = med_ID;
    }

    public int getVenteNumber() {
        return VenteNumber;
    }

    public void setVenteNumber(int venteNumber) {
        VenteNumber = venteNumber;
    }

    public int getMed_Quantity() {
        return med_Quantity;
    }

    public void setMed_Quantity(int med_Quantity) {
        this.med_Quantity = med_Quantity;
    }

    public String getMed_Name() {
        return med_Name;
    }

    public void setMed_Name(String med_Name) {
        this.med_Name = med_Name;
    }

    public int getMed_Total() {
        return med_Total;
    }

    public void setMed_Total(int med_Total) {
        this.med_Total = med_Total;
    }

    public int getMed_Price() {
        return med_Price;
    }

    public void setMed_Price(int med_Price) {
        this.med_Price = med_Price;
    }
}