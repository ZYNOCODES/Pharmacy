package com.example.ihmproject.Controllers;

import com.example.ihmproject.Containers.CaisseContainer;
import com.example.ihmproject.Containers.StockContainer;
import com.example.ihmproject.Models.UserInterFaceModel;
import com.example.ihmproject.UserInterFace;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class UserInterFaceController implements Initializable {

    @FXML
    private BorderPane MainContainer;

    public void CaisseBTN(ActionEvent event) throws IOException {
        loadScene("./CaisseContainer.fxml");
    }

    public void StockBTN(ActionEvent event) throws IOException {
        loadScene("./StockContainer.fxml");
    }


    public void MedBTN(ActionEvent event) throws IOException {
        loadScene("MedicamentContainer.fxml");
    }


    public void VenteBTN(ActionEvent event) throws IOException {
        loadScene("VenteContainer.fxml");
    }


    public void ComBTN(ActionEvent event) throws IOException {
        loadScene("CommandeContainer.fxml");
    }

    public void LOGOUT(ActionEvent event) throws IOException {

    }


    private void loadScene(String sc) throws IOException {
        Parent root = null;
        URL    url  = null;
        String sceneFile = sc;
        url  = Objects.requireNonNull(getClass().getClassLoader().getResource(sc));
        root = FXMLLoader.load(url);
        MainContainer.setCenter(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}