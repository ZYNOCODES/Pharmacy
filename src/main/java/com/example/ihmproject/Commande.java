package com.example.ihmproject;

public class Commande {
    private int med_Quantity;
    private String med_Name;
    private int med_ID;
    private int com_Number;
    private String com_Condition;
    private String com_Date;
    public Commande() {
    }

    public Commande(int com_Number, String com_Condition, String com_Date) {
        this.com_Number = com_Number;
        this.com_Condition = com_Condition;
        this.com_Date = com_Date;
    }

    public Commande(int med_Quantity, String med_Name, int med_ID, int com_Number) {
        this.med_Quantity = med_Quantity;
        this.med_Name = med_Name;
        this.med_ID = med_ID;
        this.com_Number = com_Number;
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

    public int getMed_ID() {
        return med_ID;
    }

    public void setMed_ID(int med_ID) {
        this.med_ID = med_ID;
    }

    public int getCom_Number() {
        return com_Number;
    }

    public void setCom_Number(int com_Number) {
        this.com_Number = com_Number;
    }

    public String getCom_Condition() {
        return com_Condition;
    }

    public void setCom_Condition(String com_Condition) {
        this.com_Condition = com_Condition;
    }

    public String getCom_Date() {
        return com_Date;
    }

    public void setCom_Date(String com_Date) {
        this.com_Date = com_Date;
    }
}
