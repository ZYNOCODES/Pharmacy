package com.example.ihmproject.Containers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CommandeContainer extends AnchorPane {

    public CommandeContainer() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CommandeContainer.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
