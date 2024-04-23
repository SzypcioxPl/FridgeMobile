package com.example.fridgemobile;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/Przepisy";
    private static final String USER = "root";
    private static final String PASSWORD = "zsme";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            Log.e("DatabaseConnector", "Error connecting to database", e);
            return null;
        }
    }
}
