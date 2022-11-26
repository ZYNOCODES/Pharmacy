package com.example.ihmproject.Models;


/**
 *
 * @author Admin
 */
public class Medicament {
    private int med_ID;
    private int med_Quantity;
    private String med_Name;
    private String med_Date;
    private String med_EndDate;
    private String med_Category;
    private int med_Price;

    private static int count;

    public Medicament(){
        count++;
        med_ID = count;
    }

    public int getMed_ID() {
        return med_ID;
    }

    public void setMed_ID(int med_ID) {
        this.med_ID = med_ID;
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

    public String getMed_Date() {
        return med_Date;
    }

    public void setMed_Date(String med_Date) {
        this.med_Date = med_Date;
    }

    public String getMed_EndDate() {
        return med_EndDate;
    }

    public void setMed_EndDate(String med_EndDate) {
        this.med_EndDate = med_EndDate;
    }

    public String getMed_Category() {
        return med_Category;
    }

    public void setMed_Category(String med_Category) {
        this.med_Category = med_Category;
    }

    public int getMed_Price() {
        return med_Price;
    }

    public void setMed_Price(int med_Price) {
        this.med_Price = med_Price;
    }

    @Override
    public String toString() {
        //return "Medicament{" + "med_Name=" + med_Name + '}';
        return med_Name;
    }








}
