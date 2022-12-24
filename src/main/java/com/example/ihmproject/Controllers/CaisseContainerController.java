package com.example.ihmproject.Controllers;

import com.example.ihmproject.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CaisseContainerController implements Initializable {
    @FXML
    private TableView<Medicament> StockCaisseTable;
    @FXML
    private TableColumn<Medicament,String> Name_StockTable;
    @FXML
    private TableColumn<Medicament,String> ID_StockTable,Price_StockTable,Quantity_StockTable;
    @FXML
    private TableView<Vente> VenteCaisseTable;
    @FXML
    private TableColumn<Vente,String> Name_VenteTable;
    @FXML
    private TableColumn<Vente,String> Total_VenteTable,Price_VenteTable,Quantity_VenteTable;
    @FXML
    private Button AddVenteBTN,ViewDetailsBTN,RemoveBTN,CheckOutBTN,ApdateQuantityBTN,ViewitemsBTN;
    @FXML
    private TextField QuantityTextField,PriceTextField;
    @FXML
    private Spinner<Integer> QuantitySpinner;
    private SpinnerValueFactory<Integer> valueFactory;
    private Validator validator = new Validator();
    private ArrayList<String> errorArray = new ArrayList();
    private Vente vn = new Vente();
    private int Med_Id = 0, VenteNumber = 1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showMedicament();
        showVente();
    }
    public void showMedicament(){
        ObservableList<Medicament> MedicamentList = MedicamentDB.getMedicament();
        StockCaisseTable.setItems(MedicamentList);
        Name_StockTable.setCellValueFactory(new PropertyValueFactory<>("med_Name"));
        Quantity_StockTable.setCellValueFactory(new PropertyValueFactory<>("med_Quantity"));
        Price_StockTable.setCellValueFactory(new PropertyValueFactory<>("med_Price"));

    }
    public void showVente(){
        ObservableList<Vente> Ventemedicament = VenteDB.getVente();
        VenteCaisseTable.setItems(Ventemedicament);
        Name_VenteTable.setCellValueFactory(new PropertyValueFactory<>("med_Name"));
        Total_VenteTable.setCellValueFactory(new PropertyValueFactory<>("med_Total"));
        Quantity_VenteTable.setCellValueFactory(new PropertyValueFactory<>("med_Quantity"));
        Price_VenteTable.setCellValueFactory(new PropertyValueFactory<>("med_Price"));
    }
    public void RemoveVenteBTN(ActionEvent actionEvent) {
        if(Med_Id != 0){
            VenteDB.RemoveVente(Med_Id);
            Med_Id = 0;
        }
        showVente();
    }

    public void CheckOutBTN(ActionEvent actionEvent) {
        VenteNumber++;
    }

    public void ViewitemsBTN(ActionEvent actionEvent) {
    }
    @FXML
    public void getItemStockTable(MouseEvent mouseEvent) {
        Medicament medicament = StockCaisseTable.getSelectionModel().getSelectedItem();
        //spinner initialization
        valueFactory= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,medicament.getMed_Quantity(),1);
        QuantitySpinner.setValueFactory(valueFactory);

        final int[] med_Quantity = {QuantitySpinner.getValue()};
        final int[] med_Price = {medicament.getMed_Price()};

        AddVenteBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                med_Quantity[0] = QuantitySpinner.getValue();
                if (!validator.isStringValid(PriceTextField.getText())){
                    int med_Total;
                    //calculate the total price of one medicament
                    med_Total = med_Price[0] * med_Quantity[0];
                    //add the vente to DB
                    VenteDB.ADDVente(VenteNumber,medicament.getMed_Name(), med_Quantity[0], med_Price[0],med_Total);

                }else {
                    if(validator.isValidInteger(PriceTextField.getText())){
                        //reset the value of price to the new incoming value
                        med_Price[0] = Integer.parseInt(PriceTextField.getText());
                        //calculate the total price of one medicament
                        int med_Total;
                        med_Total = med_Price[0] * med_Quantity[0];
                        //add the vente to DB
                        VenteDB.ADDVente(VenteNumber,medicament.getMed_Name(), med_Quantity[0], med_Price[0],med_Total);
                        PriceTextField.setText(null);
                        //reset the initvalue of price
                        med_Price[0] = medicament.getMed_Price();
                    }
                    else {
                        PriceTextField.setText(null);
                        //reset the initvalue of price
                        med_Price[0] = medicament.getMed_Price();
                        //show the alert messege
                        Dialog<String> dialog = new Dialog<String>();
                        dialog.setTitle("Error value format");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("Price. Please enter a number.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                }
                //reset the initvalue of spinner to 1
                valueFactory= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,medicament.getMed_Quantity(),1);
                QuantitySpinner.setValueFactory(valueFactory);
                //redisplay the vente table
                showVente();

            }
        });

    }
    @FXML
    public void getItemVenteTable(MouseEvent mouseEvent){
        Vente vente = VenteCaisseTable.getSelectionModel().getSelectedItem();
        Med_Id = vente.getMed_ID();

        final int[] med_TotalPrice = {vente.getMed_Total()};
        int med_Price = vente.getMed_Price();
        ApdateQuantityBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!validator.isStringValid(QuantityTextField.getText())){

                    //Check out

                }else {
                    if(validator.isValidInteger(QuantityTextField.getText())){
                        if(Med_Id != 0) {
                            med_TotalPrice[0] = med_Price * Integer.parseInt(QuantityTextField.getText());
                            VenteDB.updateVente(Med_Id, Integer.parseInt(QuantityTextField.getText()), med_TotalPrice[0]);
                            //redisplay the vente table
                            showVente();
                            Med_Id = 0;
                            QuantityTextField.setText(null);
                        }
                    }
                    else {
                        QuantityTextField.setText(null);
                        //show the alert messege
                        Dialog<String> dialog = new Dialog<String>();
                        dialog.setTitle("Error value format");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("Quantity. Please enter a number.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                }


            }
        });
    }


}
