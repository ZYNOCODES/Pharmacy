package com.example.ihmproject.Controllers;
import com.example.ihmproject.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommandeContainerController implements Initializable {

    @FXML
    private TextField MedNameTextField,MedQuantityTextField;
    @FXML
    private Button AddBTN,ValideBTN;
    @FXML
    private TableView<Commande> CommandeItemsTable;
    @FXML
    private TableColumn<Commande,String> NAMEcol;
    @FXML
    private TableColumn<Commande,Integer> Quantitycol,IDItemscol;
    @FXML
    private TableView<Commande> CommandeTable;
    @FXML
    private TableColumn<Commande,Integer> Numbercol;
    @FXML
    private TableColumn<Commande,String> Conditioncol,Datecol;
    int id_Items = 0, CommandeNumber= CommandeDB.lastNumber()+1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showCommande();
    }
    @FXML
    public void AddBTN(ActionEvent actionEvent) {
        String MedName = MedNameTextField.getText();

        Validator validator = new Validator();
        Commande commande =  new Commande();

        ArrayList<String> errorArray = new ArrayList();
        if(validator.isStringValid(MedName)){
            commande.setMed_Name(MedName);
        }
        else
        {
            errorArray.add("Medicament Name");
            MedQuantityTextField.setText(null);
        }

        if((validator.isStringValid(MedQuantityTextField.getText())) &&
                (validator.isValidInteger(MedQuantityTextField.getText())) ){
            int MedQuantity = Integer.parseInt(MedQuantityTextField.getText());
            commande.setMed_Quantity(MedQuantity);
        }
        else
        {
            errorArray.add("Quantity ");
            MedQuantityTextField.setText(null);

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
            CommandeDB.ADDCommandeItem(MedNameTextField.getText(), Integer.parseInt(MedQuantityTextField.getText()),CommandeNumber);
            showCommandeItems(CommandeNumber);
            clearFields();
        }

    }
    @FXML
    private void UpdateBTN(ActionEvent actionEvent) {
        if(id_Items != 0){
            CommandeDB.updateCommandeItems(id_Items, Integer.parseInt(MedQuantityTextField.getText()), MedNameTextField.getText());
            showCommandeItems(CommandeNumber);
            id_Items = 0;
            clearFields();
            AddBTN.setDisable(false);
        }
    }
    @FXML
    private void RemoveBTN(ActionEvent actionEvent) {
        if(id_Items != 0){
            CommandeDB.RemoveCommandeItem(id_Items);
            showCommandeItems(CommandeNumber);
            id_Items = 0;
            clearFields();
            AddBTN.setDisable(false);
        }
    }
    private void clearFields(){
        MedNameTextField.setText(null);
        MedQuantityTextField.setText(null);
    }
    private void showCommandeItems(int CommandeNumber){
        ObservableList<Commande> CommandeList = CommandeDB.getCommandeItem(CommandeNumber);
        CommandeItemsTable.setItems(CommandeList);
        NAMEcol.setCellValueFactory(new PropertyValueFactory<>("med_Name"));
        Quantitycol.setCellValueFactory(new PropertyValueFactory<>("med_Quantity"));
        IDItemscol.setCellValueFactory(new PropertyValueFactory<>("med_ID"));

    }
    public void AddItemBTN(ActionEvent actionEvent) {
        AddBTN.setDisable(false);
        ObservableList<Commande> items = CommandeItemsTable.getItems();
        if (!(items.isEmpty())){

            String CommandeCondition = "Invalide";
            String date = new SimpleDateFormat("dd-MM-  yyyy").format(Calendar.getInstance().getTime());
            CommandeDB.ADDCommande(CommandeNumber,CommandeCondition,date);

            CommandeNumber++;
            showCommandeItems(CommandeNumber);
            showCommande();
        }else {
            Dialog<String> dialog = new Dialog<String>();
            dialog.setTitle("Alert");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Commande items is null");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }


    }
    public void showCommande(){
        ObservableList<Commande> CommandeList = CommandeDB.getCommande();
        CommandeTable.setItems(CommandeList);
        Numbercol.setCellValueFactory(new PropertyValueFactory<>("com_Number"));
        Datecol.setCellValueFactory(new PropertyValueFactory<>("com_Date"));
        Conditioncol.setCellValueFactory(new PropertyValueFactory<>("com_Condition"));
    }
    public void getitem(MouseEvent mouseEvent) {
        ObservableList<Commande> items = CommandeItemsTable.getItems();
        if (!(items.isEmpty())){
            Commande commande = CommandeItemsTable.getSelectionModel().getSelectedItem();
            id_Items = commande.getMed_ID();
            MedNameTextField.setText(commande.getMed_Name());
            MedQuantityTextField.setText(String.valueOf(commande.getMed_Quantity()));
            if ((!MedNameTextField.getText().isEmpty())
                    && (!MedQuantityTextField.getText().isEmpty())){
                AddBTN.setDisable(true);
            }else AddBTN.setDisable(false);
        }else {
            Dialog<String> dialog = new Dialog<String>();
            dialog.setTitle("Alert");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Commande items is null");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }


    }
    public void CommandeTable(MouseEvent mouseEvent) {
        Commande commande = CommandeTable.getSelectionModel().getSelectedItem();
        int Number = commande.getCom_Number();
        ValideBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CommandeDB.updateCommandeCondition(Number);
                showCommande();
            }
        });

    }
}
