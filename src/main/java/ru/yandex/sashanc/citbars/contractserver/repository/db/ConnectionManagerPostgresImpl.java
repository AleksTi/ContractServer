package ru.yandex.sashanc.citbars.contractserver.repository.db;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerPostgresImpl implements IConnectionManager {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/contracts";
    private static final String DB_NAME = "postgres";
    private static final String DB_PASSWORD = "sd456jk+L";
    private static final Logger logger = Logger.getLogger(ConnectionManagerPostgresImpl.class);
    private static IConnectionManager connectionManager;

    private ConnectionManagerPostgresImpl(){
    }

    public static IConnectionManager getInstance() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManagerPostgresImpl();
        }
        return connectionManager;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
        } catch (SQLException e) {
            logger.warn("Ошибка при подключении к БД", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}


