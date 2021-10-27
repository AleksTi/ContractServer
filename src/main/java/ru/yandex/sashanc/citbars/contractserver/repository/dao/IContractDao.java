package ru.yandex.sashanc.citbars.contractserver.repository.dao;

import ru.yandex.sashanc.citbars.contractserver.model.pojo.Contract;

import java.util.List;

public interface IContractDao {
    List<Contract> getContractList();
}
