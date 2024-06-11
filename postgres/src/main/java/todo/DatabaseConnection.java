package todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String URL = "jdbc:postgresql://localhost:5432/todo_db";
    private static String USER = "postgres";
    private static String PASSWORD = "postgres";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
