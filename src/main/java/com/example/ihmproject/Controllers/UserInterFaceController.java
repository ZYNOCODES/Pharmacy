package com.example.ihmproject.Controllers;

import com.example.ihmproject.Models.UserInterFaceModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class UserInterFaceController {
    @FXML
    private Button CaisseBTN;
    @FXML
    private Button StockBTN;
    @FXML
    private Button MedBTN;
    @FXML
    private Button VenteBTN;
    @FXML
    private Button ComBTN;
    @FXML
    private Button LOGOUT;
    @FXML
    private Pane userProcessContainer,CaisseContainer
            ,StockContainer,MedicamentContainer
            ,VenteContainer,CommandeContainer;

    private UserInterFaceModel model = new UserInterFaceModel();
    @FXML
    private void handleButtonAction(ActionEvent event) {

        CaisseBTN.setOnAction(ActionEvent ->{
            model.showCaisseContainer(userProcessContainer,StockContainer);
        });

        StockBTN.setOnAction(ActionEvent ->{
            model.showStockContainer(userProcessContainer,CaisseContainer);
        });

        MedBTN.setOnAction(ActionEvent ->{
            model.showMedicamentContainer(userProcessContainer,MedicamentContainer);
        });

        VenteBTN.setOnAction(ActionEvent ->{
            model.showVenteContainer(userProcessContainer,VenteContainer);
        });

        ComBTN.setOnAction(ActionEvent ->{
            model.showCommandeContainer(userProcessContainer,CommandeContainer);
        });

        LOGOUT.setOnAction(ActionEvent ->{
            model.LOGOUT();
        });
    }

}