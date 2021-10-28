package ru.yandex.sashanc.citbars.contractserver.repository.db;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerPostgresImpl implements IConnectionManager {
    private static Logger logger = Logger.getLogger(ConnectionManagerPostgresImpl.class);
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
        String url = "jdbc:postgresql://localhost:5432/contracts";
        String name = "postgres";
        String password = "sd456jk+L";
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);
        } catch (SQLException e) {
            logger.warn("Ошибка при подключении к БД", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}


