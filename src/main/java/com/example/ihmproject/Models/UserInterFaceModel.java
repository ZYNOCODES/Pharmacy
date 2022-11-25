package com.example.ihmproject.Models;

import javafx.scene.layout.Pane;

public class UserInterFaceModel {
    public void showCaisseContainer(Pane userProcessContainer, Pane CaisseContainer) {
        userProcessContainer.getChildren().clear();
        userProcessContainer.getChildren().add(CaisseContainer);
    }

    public void showStockContainer(Pane userProcessContainer, Pane StockContainer) {
        userProcessContainer.getChildren().clear();
        userProcessContainer.getChildren().add(StockContainer);
    }
    public void showMedicamentContainer(Pane userProcessContainer, Pane MedicamentContainer) {
        userProcessContainer.getChildren().clear();
        userProcessContainer.getChildren().add(MedicamentContainer);
    }

    public void showVenteContainer(Pane userProcessContainer, Pane VenteContainer) {
        userProcessContainer.getChildren().clear();
        userProcessContainer.getChildren().add(VenteContainer);
    }
    public void showCommandeContainer(Pane userProcessContainer, Pane CommandeContainer) {
        userProcessContainer.getChildren().clear();
        userProcessContainer.getChildren().add(CommandeContainer);
    }

    public void LOGOUT() {

    }
}
