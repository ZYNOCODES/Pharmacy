package com.example.ihmproject.Controllers;

import com.example.ihmproject.Medicament;
import com.example.ihmproject.MedicamentDB;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class MedicamentContainerController implements Initializable {
    @FXML
    private TableView<Medicament> MedicamentContainerTable;
    @FXML
    private TableColumn<Medicament,String> Name;
    @FXML
    private TableColumn<Medicament,String> Category;
    @FXML
    private TableColumn<Medicament,Integer> ID;
    @FXML
    private TableColumn<Medicament,Integer> Quantity;
    @FXML
    private TableColumn<Medicament,String> StartDate;
    @FXML
    private TableColumn<Medicament,String> EndDate;
    @FXML
    private TableColumn<Medicament,Integer> Price;

    @FXML
    private TextField SearchInput;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showMedicament();
        Search();

    }
    public void showMedicament(){
        ObservableList<Medicament> MedicamentList = MedicamentDB.getMedicament();
        MedicamentContainerTable.setItems(MedicamentList);
        Name.setCellValueFactory(new PropertyValueFactory<>("med_Name"));
        Category.setCellValueFactory(new PropertyValueFactory<>("med_Category"));
        ID.setCellValueFactory(new PropertyValueFactory<>("med_ID"));
        Quantity.setCellValueFactory(new PropertyValueFactory<>("med_Quantity"));
        StartDate.setCellValueFactory(new PropertyValueFactory<>("med_Date"));
        EndDate.setCellValueFactory(new PropertyValueFactory<>("med_EndDate"));
        Price.setCellValueFactory(new PropertyValueFactory<>("med_Price"));
    }

    public void SearchInput(ActionEvent actionEvent) {

    }

    public void SearchBTN(ActionEvent actionEvent) {

    }
    private void Search(){
        ObservableList<Medicament> MedicamentList = MedicamentDB.getMedicament();
        FilteredList<Medicament> filteredList = new FilteredList<>(MedicamentList,b->true);
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
                    }else if (Medicament.getMed_Category().toLowerCase().indexOf(Search) > -1){
                        return true;//search by category
                    }else if (Medicament.getMed_Date().toLowerCase().indexOf(Search) > -1){
                        return true;//search by date
                    }else if (Medicament.getMed_EndDate().toLowerCase().indexOf(Search) > -1){
                        return true;//search by enddate
                    }else
                        return false;//can't find the input

                });

        });
        SortedList<Medicament> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(MedicamentContainerTable.comparatorProperty());
        //redisplay table
        MedicamentContainerTable.setItems(sortedList);
    }

}