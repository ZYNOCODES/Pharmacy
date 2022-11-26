package com.example.ihmproject.Controllers;

import com.example.ihmproject.ManagerInterFace;
import com.example.ihmproject.UserInterFace;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ManagerInterFaceController implements Initializable {
    @FXML
    private BorderPane ManagerContainer;



    public void StockBTN(ActionEvent event) throws IOException {
        loadScene("StockContainer.fxml");
    }


    public void MedBTN(ActionEvent event) throws IOException {
        loadScene("MedicamentContainer.fxml");
    }


    public void ComBTN(ActionEvent event) throws IOException {
        loadScene("CommandeContainer.fxml");
    }


    private void loadScene(String sc) throws IOException {

        Parent root = FXMLLoader.load(ManagerInterFace.class.getResource(sc));
        ManagerContainer.setCenter(root);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadScene("StockContainer.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}