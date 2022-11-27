package com.example.ihmproject.Controllers;


import com.example.ihmproject.Models.UserInterFaceModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserInterFaceController implements Initializable {
    @FXML
    private Button CaisseBTN,StockBTN,MedBTN,VenteBTN,ComBTN;
    @FXML
    private BorderPane UserContainer;
    private UserInterFaceModel UserModel = new UserInterFaceModel();

    public void CaisseBTN(ActionEvent event) throws IOException {
        UserModel.loadScene(UserContainer,"CaisseContainer.fxml",CaisseBTN);
    }

    public void StockBTN(ActionEvent event) throws IOException {
        UserModel.loadScene(UserContainer,"StockContainer.fxml",StockBTN);
    }


    public void MedBTN(ActionEvent event) throws IOException {
        UserModel.loadScene(UserContainer,"MedicamentContainer.fxml",MedBTN);
    }


    public void VenteBTN(ActionEvent event) throws IOException {
        UserModel.loadScene(UserContainer,"VenteContainer.fxml",VenteBTN);
    }


    public void ComBTN(ActionEvent event) throws IOException {
        UserModel.loadScene(UserContainer,"CommandeContainer.fxml",ComBTN);
    }

    public void LOGOUT(ActionEvent event) throws IOException {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            UserModel.loadScene(UserContainer,"CaisseContainer.fxml",CaisseBTN);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}