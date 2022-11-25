package com.example.ihmproject.Containers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class VenteContainer extends AnchorPane {

    public VenteContainer() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VenteContainer.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
