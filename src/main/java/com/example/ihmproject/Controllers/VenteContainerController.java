package com.example.ihmproject.Controllers;

import com.example.ihmproject.Vente;
import com.example.ihmproject.VenteDB;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class VenteContainerController implements Initializable {
    @FXML
    private TableView<Vente> VenteTable;
    @FXML
    private TableColumn<Vente,String> NameVenteTable;
    @FXML
    private TableColumn<Vente,Integer> PriceVenteTable,QuantityVenteTable,TotalVenteTable;
    @FXML
    private TextField VenteTotalPriceTextField;
    private int Med_Id = 0;
    @FXML
    private Spinner<Integer> VenteNumberspinner;
    private SpinnerValueFactory<Integer> valueFactory;
    private VenteDB venteDB= new VenteDB();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //init spinner
        valueFactory= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);
        VenteNumberspinner.setValueFactory(valueFactory);
        //display table
        showVente();
        //init the textfiled with total price
        int Total=venteDB.calcTotalPrice(VenteNumberspinner.getValue());
        VenteTotalPriceTextField.setText(Total+" DZD");
    }
    public void showVente(){
        //getting the data at the expense of venteNumber
        ObservableList<Vente> Ventemedicament = VenteDB.getVente();

        VenteTable.setItems(Ventemedicament);
        NameVenteTable.setCellValueFactory(new PropertyValueFactory<>("med_Name"));
        TotalVenteTable.setCellValueFactory(new PropertyValueFactory<>("med_Total"));
        QuantityVenteTable.setCellValueFactory(new PropertyValueFactory<>("med_Quantity"));
        PriceVenteTable.setCellValueFactory(new PropertyValueFactory<>("med_Price"));
    }
    public void ApdateBTN(ActionEvent actionEvent) {
    }

    public void RemoveBTN(ActionEvent actionEvent) {
        if(VenteNumberspinner.getValue() != 0){
            VenteDB.RemoveOrderVente(VenteNumberspinner.getValue());
            //redisplay the init spinner value
            valueFactory= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);
            VenteNumberspinner.setValueFactory(valueFactory);
            //redisplay the init total price value
            int Total=venteDB.calcTotalPrice(VenteNumberspinner.getValue());
            VenteTotalPriceTextField.setText(Total+" DZD");
        }
        //redisplay the table
        showVente();
    }

    public void getitem(MouseEvent mouseEvent) {
        Vente vente = VenteTable.getSelectionModel().getSelectedItem();
        Med_Id = vente.getMed_ID();
    }
    public void VenteNumberspinner(MouseEvent mouseEvent) {

        if (VenteNumberspinner.getValue()==0){
            //getting all the vente data
            ObservableList<Vente> Ventemedicament = VenteDB.getVente();
            VenteTable.setItems(Ventemedicament);
            NameVenteTable.setCellValueFactory(new PropertyValueFactory<>("med_Name"));
            TotalVenteTable.setCellValueFactory(new PropertyValueFactory<>("med_Total"));
            QuantityVenteTable.setCellValueFactory(new PropertyValueFactory<>("med_Quantity"));
            PriceVenteTable.setCellValueFactory(new PropertyValueFactory<>("med_Price"));
            //calc of total price for all ventes
            int Total=venteDB.calcTotalPrice(VenteNumberspinner.getValue());
            VenteTotalPriceTextField.setText(Total+" DZD");
        }else {
            //getting the data at the expense of the vente Number returned from a spinner
            ObservableList<Vente> Ventemedicament = VenteDB.getVente(VenteNumberspinner.getValue());
            VenteTable.setItems(Ventemedicament);
            NameVenteTable.setCellValueFactory(new PropertyValueFactory<>("med_Name"));
            TotalVenteTable.setCellValueFactory(new PropertyValueFactory<>("med_Total"));
            QuantityVenteTable.setCellValueFactory(new PropertyValueFactory<>("med_Quantity"));
            PriceVenteTable.setCellValueFactory(new PropertyValueFactory<>("med_Price"));
            //calc of total price at the expense of the vente Number returned from a spinner
            int Total=venteDB.calcTotalPrice(VenteNumberspinner.getValue());
            VenteTotalPriceTextField.setText(Total+" DZD");
        }

    }
}