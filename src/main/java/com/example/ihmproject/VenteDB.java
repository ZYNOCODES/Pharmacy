package com.example.ihmproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class VenteDB extends Vente {
    static Connection connection = DataBase.getConnection();
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    //getting vente from DB
    public static ObservableList<Vente> getVente(){
        ObservableList<Vente> Vente = FXCollections.observableArrayList();

        String query = "select * from Vente";
        try {
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int med_ID = resultSet.getInt("med_ID");
                int VenteNumber = resultSet.getInt("VenteNumber");
                int Med_Quantity = resultSet.getInt("med_Quantity");
                int Med_Price = resultSet.getInt("med_Price");
                int med_Total = resultSet.getInt("med_TotalPrice");
                String Med_Name = resultSet.getString("med_Name");
                Vente vente = new Vente(med_ID,VenteNumber,Med_Quantity,Med_Name,med_Total,Med_Price);
                Vente.add(vente);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Vente;
    }
    //add a vente to DB
    public static void ADDVente(Integer VenteNumber, String MedName, Integer MedQuantity, Integer MedPrice, Integer MedTotalPrice){
        String query = "insert into Vente(med_Name, med_Price, med_Quantity, med_TotalPrice, VenteNumber) values(?, ?, ?, ?, ?)";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, MedName);
            statement.setInt(2, MedPrice);
            statement.setInt(3, MedQuantity);
            statement.setInt(4, MedTotalPrice);
            statement.setInt(5, VenteNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //update vente at the expense of an id
    public static void updateVente(int Med_ID, int MedQuantity, int TotalPrice){

        String query = "update Vente set med_Quantity = ? ,med_TotalPrice = ? where med_ID = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, MedQuantity);
            statement.setInt(2, TotalPrice);
            statement.setInt(3, Med_ID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //remove vente at the expense of an id
    public static void RemoveVente(int Med_Id){
        String query = "delete from Vente where med_ID = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, Med_Id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public int getVenteNumber(){
//        int number;
//        String query = "select * from Vente ORDER BY VenteNumber DESC LIMIT 1";
//
//        try {
//            statement = connection.prepareStatement(query);
//            resultSet = statement.executeQuery();
//            number = resultSet.getInt("VenteNumber");
//            return number;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


// getting the data at the expense of the vente Number
    public static ObservableList<Vente> getVente(int venteNumber){
        ObservableList<Vente> Vente = FXCollections.observableArrayList();

        String query = "select * from Vente where VenteNumber = ?";
        try {
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,venteNumber);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int med_ID = resultSet.getInt("med_ID");
                int Vente_Number = resultSet.getInt("VenteNumber");
                int Med_Quantity = resultSet.getInt("med_Quantity");
                int Med_Price = resultSet.getInt("med_Price");
                int med_Total = resultSet.getInt("med_TotalPrice");
                String Med_Name = resultSet.getString("med_Name");
                Vente vente = new Vente(med_ID,Vente_Number,Med_Quantity,Med_Name,med_Total,Med_Price);
                Vente.add(vente);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Vente;
    }

    //calculate the total price
    public int calcTotalPrice(int venteNumber){
        int calc = 0;
        if(venteNumber >= 1){
            String query = "select med_TotalPrice from Vente where VenteNumber = ?";
            try {
                statement = connection.prepareStatement(query);
                statement.setInt(1,venteNumber);
                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    calc +=resultSet.getInt("med_TotalPrice");
                }
                return calc;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            String query = "select med_TotalPrice from Vente";
            try {
                statement = connection.prepareStatement(query);
                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    calc +=resultSet.getInt("med_TotalPrice");
                }
                return calc;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    //  remove vente at the expense of an venteNumber
    public static void RemoveOrderVente(int venteNumber){
        String query = "delete from Vente where venteNumber = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, venteNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //get the last vente number from DB
    public static int lastNumber(){
        int id = 0;
        String query = "select venteNumber from Vente where venteNumber=(select max(venteNumber) from Vente)";
        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getInt("venteNumber");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //if the vente table in DB is null
        if (id >= 0){
            return id;
        }else {
            return id=0;
        }

    }

}


