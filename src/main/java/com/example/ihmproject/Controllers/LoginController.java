package com.example.ihmproject.Controllers;

import com.example.ihmproject.UserInterFace;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField PasswordTextField,UsernameTextField;
    @FXML
    private Button LoginBTN;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoginBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if ((UsernameTextField.getText().toString().equals("Admin"))
                        && (PasswordTextField.getText().toString().equals("123"))){
                    Stage primaryStage = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(UserInterFace.class.getResource("UserInterFace.fxml"));
                    Scene scene = null;
                    try {
                        scene = new Scene(fxmlLoader.load());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    primaryStage.setScene(scene);
                    primaryStage.show();
                }else if ((UsernameTextField.getText().toString().equals("Manager"))
                        && (PasswordTextField.getText().toString().equals("123"))){
                    Stage primaryStage = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(UserInterFace.class.getResource("ManagerInterFace.fxml"));
                    Scene scene = null;
                    try {
                        scene = new Scene(fxmlLoader.load());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    primaryStage.setScene(scene);
                    primaryStage.show();
                }else if ((UsernameTextField.getText().toString().equals("Seller"))
                        && (PasswordTextField.getText().toString().equals("123"))){
                    Stage primaryStage = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(UserInterFace.class.getResource("SellerInterFace.fxml"));
                    Scene scene = null;
                    try {
                        scene = new Scene(fxmlLoader.load());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    primaryStage.setScene(scene);
                    primaryStage.show();
                }else {
                    Dialog<String> dialog = new Dialog<String>();
                    dialog.setTitle("Alert");
                    ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                    dialog.setContentText("Username or password incorrect");
                    dialog.getDialogPane().getButtonTypes().add(type);
                    dialog.showAndWait();
                }
            }
        });
    }

    public void LoginBTN(ActionEvent actionEvent) throws IOException {

    }
}
