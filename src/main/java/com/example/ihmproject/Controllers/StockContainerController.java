package com.example.ihmproject.Controllers;

import com.example.ihmproject.Models.Medicament;
import com.example.ihmproject.Models.Validator;
import com.example.ihmproject.UserInterFace;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.print.attribute.standard.DialogOwner;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StockContainerController implements Initializable {

    @FXML
    private TextField MedNameTextField, MedCategoryTextField, MedDateTextField, MedEndDateTextField, MedQuantityTextField, MedPriceTextField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void ADD(ActionEvent actionEvent) {
        String MedName = MedNameTextField.getText();
        String MedCategory = MedCategoryTextField.getText();
        String MedDate = MedDateTextField.getText();
        String MedEndDate = MedEndDateTextField.getText();


        Validator validator = new Validator();
        Medicament Med =  new Medicament();

        ArrayList<String> errorArray = new ArrayList();
        if(validator.isStringValid(MedName)){
            Med.setMed_Name(MedName);
        }
        else
        {
            errorArray.add("Medicament Name");
        }

        if(validator.isStringValid(MedCategory)){
            Med.setMed_Category(MedCategory);
        }
        else
        {
            errorArray.add("Medicament Category");
        }
        if(validator.isStringValid(MedDate)){
            Med.setMed_Date(MedDate);
        }
        else
        {
            errorArray.add("Medicament Date");
        }

        if(validator.isStringValid(MedEndDate)){
            Med.setMed_EndDate(MedEndDate);
        }
        else
        {
            errorArray.add("Medicament EndDate");
        }

        if((validator.isStringValid(MedQuantityTextField.getText())) &&
                (validator.isValidInteger(MedQuantityTextField.getText())) ){
            int MedQuantity = Integer.parseInt(MedQuantityTextField.getText());
            Med.setMed_Quantity(MedQuantity);
        }
        else
        {
            errorArray.add("Quantity ");
        }
        if((validator.isStringValid(MedPriceTextField.getText())) &&
                (validator.isValidInteger(MedPriceTextField.getText())) ){
            int MedPrice = Integer.parseInt(MedPriceTextField.getText());
            Med.setMed_Price(Integer.parseInt(MedPriceTextField.getText()));
        }
        else
        {
            errorArray.add("Price");
        }

        //Check is done if the errorArray contains error messages
        if(!errorArray.isEmpty()){
            String message = "";
            //Iterate the errorListArray with foreach
            for( String error : errorArray )
            {
                message += error + " \n";
            }
            Dialog<String> dialog = new Dialog<String>();
            dialog.setTitle("Error");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText(message +"are empty fields. Please enter the values.");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        } else{
            Dialog<String> dialog = new Dialog<String>();
            dialog.setTitle("Store Addition");
            ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Store is added");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();

        }

    }

    public void Cancel(ActionEvent actionEvent) {
        ArrayList<String> errorArray = new ArrayList();

        if (!MedNameTextField.getText().isEmpty()){
            errorArray.add("Medicament Name");
        }else {
            MedNameTextField.setText("");
        }

        if (!MedCategoryTextField.getText().isEmpty()){
            errorArray.add("Medicament Category");
        }else {
            MedCategoryTextField.setText("");
        }

        if (!MedDateTextField.getText().isEmpty()){
            errorArray.add("Medicament Date");
        }else {
            MedDateTextField.setText("");
        }

        if (!MedEndDateTextField.getText().isEmpty()){
            errorArray.add("Medicament EndDate");
        }else {
            MedEndDateTextField.setText("");
        }

        if (!MedQuantityTextField.getText().isEmpty()){
            errorArray.add("Medicament Quantity");
        }else {
            MedQuantityTextField.setText("");
        }

        if (!MedPriceTextField.getText().isEmpty()){
            errorArray.add("Medicament Price");
        }else {
            MedPriceTextField.setText("");
        }

        if(!errorArray.isEmpty()){
            Dialog<String> dialog = new Dialog<String>();
            dialog.setTitle("Alert");
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

            dialog.setContentText("Are you sure you wanna cancel");
            dialog.getDialogPane().getButtonTypes().add(yes);
            dialog.getDialogPane().getButtonTypes().add(no);
            dialog.showAndWait();

        }
    }

    public void EditQuantity(ActionEvent actionEvent) {
    }

    public void Remove(ActionEvent actionEvent) {
    }



}
