package com.example.ihmproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class CommandeDB {
    static Connection connection = DataBase.getConnection();
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    //getting Commande Item from DB
    public static ObservableList<Commande> getCommandeItem(){
        ObservableList<Commande> Commande = FXCollections.observableArrayList();

        String query = "select * from commande_items";
        try {
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int med_ID = resultSet.getInt("id_Items");
                int Med_Quantity = resultSet.getInt("med_Quantity");
                int com_Number = resultSet.getInt("com_Number");
                String Med_Name = resultSet.getString("med_Name");
                Commande commande = new Commande(Med_Quantity,Med_Name,med_ID,com_Number);
                Commande.add(commande);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Commande;
    }
    //add a Commande Item to DB
    public static void ADDCommandeItem(String MedName, Integer MedQuantity,Integer ComNumber){
        String query = "insert into commande_items(med_Name, med_Quantity, com_Number) values(?, ?, ?)";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, MedName);
            statement.setInt(2, MedQuantity);
            statement.setInt(3, ComNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //update Commande Item at the expense of an id
    public static void updateCommandeItems(int id_items, int MedQuantity, String med_Name){

        String query = "update commande_items set med_Name = ? ,med_Quantity = ? where id_Items = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(2, MedQuantity);
            statement.setString(1, med_Name);
            statement.setInt(3, id_items);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //remove Commande Item at the expense of an id
    public static void RemoveCommandeItem(int id_Items){
        String query = "delete from commande_items where id_Items = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, id_Items);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ObservableList<Commande> getCommandeItem(int CommandeNumber){
        ObservableList<Commande> Commande = FXCollections.observableArrayList();

        String query = "select * from commande_items where Com_Number = ?";
        try {
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, CommandeNumber);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int med_ID = resultSet.getInt("id_Items");
                int Med_Quantity = resultSet.getInt("med_Quantity");
                int com_Number = resultSet.getInt("com_Number");
                String Med_Name = resultSet.getString("med_Name");
                Commande commande = new Commande(Med_Quantity,Med_Name,med_ID,com_Number);
                Commande.add(commande);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Commande;
    }
    public static ObservableList<Commande> getCommande(){
        ObservableList<Commande> Commande = FXCollections.observableArrayList();

        String query = "select * from commande";
        try {
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int com_Number = resultSet.getInt("com_Number");
                String com_Date = resultSet.getString("com_Date");
                String com_Condition = resultSet.getString("com_Condition");
                Commande commande = new Commande(com_Number,com_Condition,com_Date);
                Commande.add(commande);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Commande;
    }
    public static void ADDCommande(Integer com_Number, String com_Condition,String com_Date){
        String query = "insert into commande(com_Date, com_Condition, com_Number) values(?, ?, ?)";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, com_Date);
            statement.setString(2, com_Condition);
            statement.setInt(3, com_Number);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static int lastNumber(){
        int id = 0;
        String query = "select com_Number from commande_items where com_Number=(select max(com_Number) from commande_items)";
        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getInt("com_Number");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (id >= 0){
            return id;
        }else {
            return id=0;
        }

    }
    public static void updateCommandeCondition(int Number){

        String query = "update commande set com_Condition = ? where com_Number = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, "Valide");
            statement.setInt(2, Number);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
