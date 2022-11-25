package com.example.ihmproject.Models;

import com.example.ihmproject.Containers.*;
import com.example.ihmproject.Controllers.UserInterFaceController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class UserInterFaceModel {
    public void showCaisseContainer(BorderPane MainContainer) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(UserInterFaceController.class.getResource("ihmproject/CaisseContainer.fxml"));
        MainContainer = loader.load();
        MainContainer.setCenter(MainContainer);
    }

    public void showStockContainer(BorderPane MainContainer) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(UserInterFaceController.class.getResource("ihmproject/StockContainer.fxml"));
        MainContainer = loader.load();
        MainContainer.setCenter(MainContainer);
    }
    public void showMedicamentContainer(BorderPane MainContainer) {
        MedicamentContainer medicamentContainer = new MedicamentContainer();
        MainContainer.setCenter(medicamentContainer);
    }

    public void showVenteContainer(BorderPane MainContainer) {
        VenteContainer venteContainer = new VenteContainer();
        MainContainer.setCenter(venteContainer);
    }
    public void showCommandeContainer(BorderPane MainContainer) {
        CommandeContainer commandeContainer = new CommandeContainer();
        MainContainer.setCenter(commandeContainer);
    }

    public void LOGOUT() {

    }
}
