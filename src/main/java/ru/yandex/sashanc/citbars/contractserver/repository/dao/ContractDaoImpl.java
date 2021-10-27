package ru.yandex.sashanc.citbars.contractserver.repository.dao;

import org.springframework.stereotype.Repository;
import ru.yandex.sashanc.citbars.contractserver.repository.db.ConnectionManagerPostgresImpl;
import ru.yandex.sashanc.citbars.contractserver.repository.db.IConnectionManager;
import ru.yandex.sashanc.citbars.contractserver.model.pojo.Contract;

import java.util.List;

@Repository
public class ContractDaoImpl implements IContractDao {
    private IConnectionManager connectionManager = ConnectionManagerPostgresImpl.getInstance();


    @Override
    public List<Contract> getContractList() {
        return null;
    }
}
