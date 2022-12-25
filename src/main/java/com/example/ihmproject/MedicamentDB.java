package com.example.ihmproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicamentDB extends Medicament{
    static Connection connection = DataBase.getConnection();
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    public static ObservableList<Medicament> getMedicament(){
        ObservableList<Medicament> medicament = FXCollections.observableArrayList();

        String query = "select * from Medicament";
        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int Med_Id = resultSet.getInt("id_Medicament");
                int med_Quantity = resultSet.getInt("med_Quantity");
                int med_Price = resultSet.getInt("med_Price");
                String med_Name = resultSet.getString("med_Name");
                String med_Category = resultSet.getString("med_Category");
                String med_Date = resultSet.getString("med_Date");
                String med_EndDate = resultSet.getString("med_EndDate");
                Medicament Med = new Medicament(Med_Id,med_Quantity,med_Name,med_Date,med_EndDate,med_Category,med_Price);
                medicament.add(Med);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return medicament;
    }

    public static void ADDMedicament(String MedNameTextField, String MedCategoryTextField, String MedDateTextField, String MedEndDateTextField, Integer MedQuantityTextField, Integer MedPriceTextField){
        String query = "insert into Medicament(med_Quantity, med_Name, med_Date, med_EndDate, med_Category, med_Price) values(?, ?, ?, ?, ?, ?)";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(2, MedNameTextField);
            statement.setString(5, MedCategoryTextField);
            statement.setString(3, MedDateTextField);
            statement.setString(4, MedEndDateTextField);
            statement.setInt(1, MedQuantityTextField);
            statement.setInt(6, MedPriceTextField);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateMedicament(int Med_ID, String MedNameTextField, String MedCategoryTextField, String MedDateTextField, String MedEndDateTextField,
                                        Integer MedQuantityTextField, Integer MedPriceTextField){

        String query = "update Medicament set med_Quantity = ?, med_Name = ?, med_Date = ?, med_EndDate = ?,med_Category = ?, med_Price = ? where id_Medicament = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(2, MedNameTextField);
            statement.setString(5, MedCategoryTextField);
            statement.setString(3, MedDateTextField);
            statement.setString(4, MedEndDateTextField);
            statement.setInt(1, MedQuantityTextField);
            statement.setInt(6, MedPriceTextField);
            statement.setInt(7, Med_ID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void RemoveMedicament(int Med_Id){
        String query = "delete from Medicament where id_Medicament = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, Med_Id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}