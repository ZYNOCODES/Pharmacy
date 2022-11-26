package com.example.ihmproject.Controllers;

import com.example.ihmproject.UserInterFace;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CommandeContainerController implements Initializable {

    @FXML
    private Button StockBTN, CaisseBTN, MedBTN, VenteBTN, ComBTN, LOGOUT;

    public void CaisseBTN(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(UserInterFace.class.getResource("CaisseContainer.fxml"));
        Stage window = (Stage) CaisseBTN.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public void StockBTN(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(UserInterFace.class.getResource("StockContainer.fxml"));
        Stage window = (Stage) StockBTN.getScene().getWindow();
        window.setScene(new Scene(root));
    }


    public void MedBTN(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(UserInterFace.class.getResource("MedicamentContainer.fxml"));
        Stage window = (Stage) MedBTN.getScene().getWindow();
        window.setScene(new Scene(root));    }


    public void VenteBTN(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(UserInterFace.class.getResource("VenteContainer.fxml"));
        Stage window = (Stage) VenteBTN.getScene().getWindow();
        window.setScene(new Scene(root));    }


    public void ComBTN(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(UserInterFace.class.getResource("CommandeContainer.fxml"));
        Stage window = (Stage) ComBTN.getScene().getWindow();
        window.setScene(new Scene(root));    }

    public void LOGOUT(ActionEvent event) throws IOException {

    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
