package com.example.ihmproject.Controllers;

import com.example.ihmproject.Medicament;
import com.example.ihmproject.MedicamentDB;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showMedicament();
    }
    public void showMedicament(){
        ObservableList<Medicament> MedicamentList = MedicamentDB.getMedicament();
        MedicamentContainerTable.setItems(MedicamentList);
        Name.setCellValueFactory(new PropertyValueFactory<>("med_Name"));
        Category.setCellValueFactory(new PropertyValueFactory<>("med_Category"));
        ID.setCellValueFactory(new PropertyValueFactory<>("id_Medicament"));
        Quantity.setCellValueFactory(new PropertyValueFactory<>("med_Quantity"));
        StartDate.setCellValueFactory(new PropertyValueFactory<>("med_Date"));
        EndDate.setCellValueFactory(new PropertyValueFactory<>("med_EndDate"));
        Price.setCellValueFactory(new PropertyValueFactory<>("med_Price"));
    }
}