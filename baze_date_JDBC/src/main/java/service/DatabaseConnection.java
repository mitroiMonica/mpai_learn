package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection databaseConnection;
    private final Connection connection;

    private DatabaseConnection() throws SQLException {
        String PASSWORD = "";
        String USER = "root";
        String DB_NAME = "invatare";
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME, USER, PASSWORD);
    }

    public static DatabaseConnection getInstance() {
        try {
            if (databaseConnection == null || databaseConnection.getConnection().isClosed()) {
                databaseConnection = new DatabaseConnection();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Connection cannot be established!", e);
        }
        return databaseConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
