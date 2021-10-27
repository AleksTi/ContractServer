package ru.yandex.sashanc.citbars.contractserver.repository.db;

import java.sql.Connection;

public interface IConnectionManager {
    Connection getConnection();
}
