package ru.yandex.sashanc.citbars.contractserver.repository.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerPostgresImpl implements IConnectionManager {
    private static IConnectionManager connectionManager;

    public static IConnectionManager getInstance() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManagerPostgresImpl();
        }
        return connectionManager;
    }

    @Override
    public Connection getConnection() {
        String url = "";
        String name = "";
        String password = "";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, name, password);
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД " + e);
        }
        return connection;
    }
}


