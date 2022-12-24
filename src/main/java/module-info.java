module com.example.ihmproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires  mysql.connector.java;
    requires java.sql;

    opens com.example.ihmproject to javafx.fxml;
    exports com.example.ihmproject;
    exports com.example.ihmproject.Controllers;
    opens com.example.ihmproject.Controllers to javafx.fxml;
}