package com.example.gradeapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/grade_management?serverTimezone=UTC";
    private static final String USER = "root"; // change
    private static final String PASSWORD = "password"; // change

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
