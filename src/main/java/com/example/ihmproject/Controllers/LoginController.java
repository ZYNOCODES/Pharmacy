package com.example.ihmproject.Controllers;

import com.example.ihmproject.UserDB;
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
                UserDB userDB = new UserDB();
                int id_User = 0 ;
                boolean empty = false;
                if ((UsernameTextField.getText().toString().isEmpty())
                || (PasswordTextField.getText().toString().isEmpty()) ) {
                    Dialog<String> dialog = new Dialog<String>();
                    dialog.setTitle("Alert");
                    ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                    dialog.setContentText("Username or password are empty");
                    dialog.getDialogPane().getButtonTypes().add(type);
                    dialog.showAndWait();
                    empty = true;
                }else {
                    id_User = userDB.getUser(UsernameTextField.getText().toString(),
                            PasswordTextField.getText().toString());
                    empty = false;
                }
                if (id_User==1 && empty == false){
                    Stage primaryStage = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(UserInterFace.class.getResource("UserInterFace.fxml"));
                    Scene scene = null;
                    try {
                        scene = new Scene(fxmlLoader.load());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    primaryStage.setScene(scene);
                    primaryStage.setTitle("Pharmacy");
                    primaryStage.show();
                }else if (id_User==2 && empty == false){
                    Stage primaryStage = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(UserInterFace.class.getResource("ManagerInterFace.fxml"));
                    Scene scene = null;
                    try {
                        scene = new Scene(fxmlLoader.load());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    primaryStage.setScene(scene);
                    primaryStage.setTitle("Pharmacy");
                    primaryStage.show();
                }else if (id_User==3 && empty == false){
                    Stage primaryStage = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(UserInterFace.class.getResource("SellerInterFace.fxml"));
                    Scene scene = null;
                    try {
                        scene = new Scene(fxmlLoader.load());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    primaryStage.setScene(scene);
                    primaryStage.setTitle("Pharmacy");
                    primaryStage.show();

                }else if (empty == false){
                    Dialog<String> dialog = new Dialog<String>();
                    dialog.setTitle("Alert");
                    ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                    dialog.setContentText("Username or password incorrect try again");
                    dialog.getDialogPane().getButtonTypes().add(type);
                    dialog.showAndWait();
                }


            }
        });
    }

    public void LoginBTN(ActionEvent actionEvent) throws IOException {

    }
}

