package ru.yandex.sashanc.citbars.contractserver.services;

import ru.yandex.sashanc.citbars.contractserver.repository.dto.ContractDto;

import java.util.List;

public interface IContractServer {
    List<ContractDto> getContractDtoList();
}
