package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String HOST = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Abakar25032003!!!";
    private static Connection connection;

    private Util() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
                System.out.println("Соединение установлено");
            } catch (SQLException e) {
                throw new RuntimeException("Не удалось установить соединение", e);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Соединение закрыто");
            } catch (SQLException e) {
                throw new RuntimeException("Не удалось закрыть соединение", e);
            }
        }
    }
}
