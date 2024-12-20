/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;

    private DatabaseConnection() {
    }

    // Singleton pattern
    public static synchronized Connection getConnection() {
        if (connection == null) {
            try {
                
                connection = DriverManager.getConnection(
                        "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=FitnessTracker; user=sa;password=12345" );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
