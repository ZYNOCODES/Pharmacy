package com.example.ihmproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    public static Connection connection;
    public static Connection getConnection(){

        String DBNAME = "ihmdatabase";
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/";
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url + DBNAME , user, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}
