package com.example.ihmproject.Controllers;

import com.example.ihmproject.Medicament;
import com.example.ihmproject.MedicamentDB;
import com.example.ihmproject.Validator;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
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
    private DatePicker MedEndDate,MedDate;
    private LocalDate LocalMedDate,LocalMedEndDate;
    @FXML
    private TextField MedNameTextField, MedCategoryTextField, MedDateTextField, MedEndDateTextField, MedQuantityTextField, MedPriceTextField;
    int Med_Id = 0;
    @FXML
    private TextField SearchInput;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showMedicament();
        Search();
    }
    public void AddBTN(ActionEvent actionEvent) {
        String MedName = MedNameTextField.getText();
        String MedCategory = MedCategoryTextField.getText();
        LocalMedDate = MedDate.getValue();
        String Med_Date = LocalMedDate.toString();
        LocalMedEndDate = MedEndDate.getValue();
        String Med_EndDate = LocalMedEndDate.toString();

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
        if(validator.isStringValid(Med_Date)){
            Med.setMed_Date(Med_Date);
        }
        else
        {
            errorArray.add("Medicament Date");
        }

        if(validator.isStringValid(Med_EndDate)){
            Med.setMed_EndDate(Med_EndDate);
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
            MedicamentDB.ADDMedicament(MedNameTextField.getText(), MedCategoryTextField.getText(), Med_Date,
                    Med_EndDate, Integer.parseInt(MedQuantityTextField.getText()), Integer.parseInt(MedPriceTextField.getText()));
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
    public void CancelBTN(ActionEvent actionEvent) {
        clearFields();
        ADD.setDisable(false);
    }
    public void UpdateBTN(ActionEvent actionEvent) {
        if(Med_Id != 0){
            MedicamentDB.updateMedicament(Med_Id, MedNameTextField.getText(), MedCategoryTextField.getText(), MedDate.getValue().toString(), MedEndDate.getValue().toString(),
                    Integer.parseInt(MedQuantityTextField.getText()), Integer.parseInt(MedPriceTextField.getText()));
            showMedicament();
            Med_Id = 0;
            clearFields();
            ADD.setDisable(false);
        }
    }
    public void RemoveBTN(ActionEvent actionEvent) {
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
        IDcol.setCellValueFactory(new PropertyValueFactory<Medicament,Integer>("med_ID"));
        QUANTITYcol.setCellValueFactory(new PropertyValueFactory<>("med_Quantity"));
    }
    public void clearFields(){
        MedNameTextField.setText(null);
        MedCategoryTextField.setText(null);
        MedDate.setDayCellFactory(null);
        MedEndDate.setDayCellFactory(null);
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
        MedDate.setValue(LocalDate.parse(medicament.getMed_Date()));
        MedEndDate.setValue(LocalDate.parse(medicament.getMed_EndDate()));
        MedQuantityTextField.setText(String.valueOf(medicament.getMed_Quantity()));
        MedPriceTextField.setText(String.valueOf(medicament.getMed_Price()));
        ADD.setDisable(true);
    }
    private void Search(){
        ObservableList<Medicament> MedicamentList = MedicamentDB.getMedicament();
        FilteredList<Medicament> filteredList = new FilteredList<>(MedicamentList, b->true);
        SearchInput.textProperty().addListener((observableValue,  oldvalue,  newvalue) -> {

            filteredList.setPredicate(Medicament -> {
                //if textfield in null
                if ((newvalue.isEmpty()) || (newvalue.isBlank()) || (newvalue==null)){
                    return true;
                }

                String Search = newvalue.toLowerCase();
                //searching
                if (Medicament.getMed_Name().toLowerCase().indexOf(Search) > -1){
                    return true;//search by name
                }else
                    return false;//can't find the input

            });

        });
        SortedList<Medicament> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(StockContainerTable.comparatorProperty());
        //redisplay table
        StockContainerTable.setItems(sortedList);
    }

}
