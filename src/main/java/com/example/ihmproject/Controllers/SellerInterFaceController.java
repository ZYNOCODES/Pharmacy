package com.example.ihmproject.Controllers;

import com.example.ihmproject.SellerInterFace;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SellerInterFaceController implements Initializable {

    @FXML
    private BorderPane SellerContainer;

    public void CaisseBTN(ActionEvent event) throws IOException {
        loadScene("CaisseContainer.fxml");
    }

    public void MedBTN(ActionEvent event) throws IOException {
        loadScene("MedicamentContainer.fxml");
    }


    private void loadScene(String sc) throws IOException {
        Parent root = FXMLLoader.load(SellerInterFace.class.getResource(sc));
        SellerContainer.setCenter(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadScene("CaisseContainer.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}