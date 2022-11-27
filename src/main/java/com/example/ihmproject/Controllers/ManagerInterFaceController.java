package com.example.ihmproject.Controllers;

import com.example.ihmproject.Models.ManagerInterFaceModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerInterFaceController implements Initializable {
    @FXML
    private Button StockBTN,MedBTN,ComBTN;
    @FXML
    private BorderPane ManagerContainer;
    private ManagerInterFaceModel UserModel = new ManagerInterFaceModel();

    public void StockBTN(ActionEvent event) throws IOException {
        UserModel.loadScene(ManagerContainer,"StockContainer.fxml",StockBTN);
    }


    public void MedBTN(ActionEvent event) throws IOException {
        UserModel.loadScene(ManagerContainer,"MedicamentContainer.fxml",MedBTN);
    }


    public void ComBTN(ActionEvent event) throws IOException {
        UserModel.loadScene(ManagerContainer,"CommandeContainer.fxml",ComBTN);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            UserModel.loadScene(ManagerContainer,"StockContainer.fxml",StockBTN);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}