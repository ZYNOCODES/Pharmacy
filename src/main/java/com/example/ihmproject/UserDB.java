package com.example.ihmproject;

import java.sql.*;

public class UserDB {
    static Connection connection = DataBase.getConnection();
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    public static int getUser(String username, String password) {
        int id = 0;
        String query = "SELECT id_User FROM user WHERE Username = ? and Password = ?";
        try {
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.getGeneratedKeys();
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id_User");
                return id;
            }
        } catch (SQLException e) {
            return -1;
        }

        return 0;
    }
}