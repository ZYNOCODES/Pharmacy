package com.example.ihmproject.Controllers;

import com.example.ihmproject.Validator;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StockContainerController implements Initializable {
    @FXML
    private Button ADD;
    @FXML
    private TableView<Medicament> StockContainerTable;
    @FXML
    private TableColumn<Medicament,String> NAMEcol;
    @FXML
    private TableColumn<Medicament,Integer> IDcol;
    @FXML
    private TableColumn<Medicament,Integer> QUANTITYcol;
    @FXML
    private TextField MedNameTextField, MedCategoryTextField, MedDateTextField, MedEndDateTextField, MedQuantityTextField, MedPriceTextField;
    int Med_Id = 0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showMedicament();
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
            MedQuantityTextField.setText("");

        }
        if((validator.isStringValid(MedPriceTextField.getText())) &&
                (validator.isValidInteger(MedPriceTextField.getText())) ){
            int MedPrice = Integer.parseInt(MedPriceTextField.getText());
            Med.setMed_Price(Integer.parseInt(MedPriceTextField.getText()));
        }
        else
        {
            errorArray.add("Price");
            MedPriceTextField.setText("");

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
            MedicamentDB.ADDMedicament(MedNameTextField.getText(), MedCategoryTextField.getText(), MedDateTextField.getText(),
                    MedEndDateTextField.getText(), Integer.parseInt(MedQuantityTextField.getText()), Integer.parseInt(MedPriceTextField.getText()));
            showMedicament();
            clearFields();

            Dialog<String> dialog = new Dialog<String>();
            dialog.setTitle("Store Addition");
            ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Store is added");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }

    }
    public void Cancel(ActionEvent actionEvent) {
        clearFields();
        ADD.setDisable(false);
    }
    public void Update(ActionEvent actionEvent) {
        if(Med_Id != 0){
            MedicamentDB.updateMedicament(Med_Id, MedNameTextField.getText(), MedCategoryTextField.getText(), MedDateTextField.getText(), MedEndDateTextField.getText(),
                    Integer.parseInt(MedQuantityTextField.getText()), Integer.parseInt(MedPriceTextField.getText()));
            showMedicament();
            Med_Id = 0;
            clearFields();
            ADD.setDisable(false);
        }
    }
    public void Remove(ActionEvent actionEvent) {
        if(Med_Id != 0){
            MedicamentDB.RemoveMedicament(Med_Id);
            showMedicament();
            Med_Id = 0;
            clearFields();
            ADD.setDisable(false);
        }
    }
    public void showMedicament(){
        ObservableList<Medicament> MedicamentList = MedicamentDB.getMedicament();
        StockContainerTable.setItems(MedicamentList);
        NAMEcol.setCellValueFactory(new PropertyValueFactory<>("med_Name"));
        IDcol.setCellValueFactory(new PropertyValueFactory<>("id_Medicament"));
        QUANTITYcol.setCellValueFactory(new PropertyValueFactory<>("med_Quantity"));
    }
    public void clearFields(){
        MedNameTextField.setText(null);
        MedCategoryTextField.setText(null);
        MedDateTextField.setText(null);
        MedEndDateTextField.setText(null);
        MedQuantityTextField.setText(null);
        MedPriceTextField.setText(null);
        Med_Id = 0;
    }
    @FXML
    public void getItem(MouseEvent mouseEvent) {
        Medicament medicament = StockContainerTable.getSelectionModel().getSelectedItem();
        Med_Id = medicament.getMed_ID();
        MedNameTextField.setText(medicament.getMed_Name());
        MedCategoryTextField.setText(medicament.getMed_Category());
        MedDateTextField.setText(medicament.getMed_Date());
        MedEndDateTextField.setText(medicament.getMed_EndDate());
        MedQuantityTextField.setText(String.valueOf(medicament.getMed_Quantity()));
        MedPriceTextField.setText(String.valueOf(medicament.getMed_Price()));
        ADD.setDisable(true);
    }
}
