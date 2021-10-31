package ru.yandex.sashanc.citbars.contractserver.repository.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import ru.yandex.sashanc.citbars.contractserver.repository.db.ConnectionManagerPostgresImpl;
import ru.yandex.sashanc.citbars.contractserver.repository.db.IConnectionManager;
import ru.yandex.sashanc.citbars.contractserver.model.pojo.Contract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ContractDaoImpl implements IContractDao {
    private static final Logger logger = Logger.getLogger(ContractDaoImpl.class);
    private final IConnectionManager connectionManager = ConnectionManagerPostgresImpl.getInstance();

    @Override
    public List<Contract> getContractList() {
        Connection connection = connectionManager.getConnection();
        List<Contract> contractList = Collections.emptyList();
        try {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM contracts")) {
                Contract contract;
                contractList = new ArrayList<>();
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    contract = new Contract(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getDate("date").toLocalDate(),
                            resultSet.getDate("editing_date").toLocalDate()
                    );
                    contractList.add(contract);
                }
            }
            connection.close();
        } catch (SQLException e) {
            logger.info("Error getting data from the database",e);
        }
        return contractList;
    }
}
