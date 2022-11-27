package com.example.ihmproject.Controllers;

import com.example.ihmproject.Models.SellerInterFaceModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SellerInterFaceController implements Initializable {
    @FXML
    private Button CaisseBTN,MedBTN;
    @FXML
    private BorderPane SellerContainer;
    private SellerInterFaceModel UserModel = new SellerInterFaceModel();


    public void CaisseBTN(ActionEvent event) throws IOException {
        UserModel.loadScene(SellerContainer,"CaisseContainer.fxml",CaisseBTN);    }

    public void MedBTN(ActionEvent event) throws IOException {
        UserModel.loadScene(SellerContainer,"MedicamentContainer.fxml",MedBTN);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            UserModel.loadScene(SellerContainer,"CaisseContainer.fxml",CaisseBTN);
    } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}