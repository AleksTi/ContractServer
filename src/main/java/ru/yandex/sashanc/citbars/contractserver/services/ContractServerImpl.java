package ru.yandex.sashanc.citbars.contractserver.services;

import org.springframework.stereotype.Service;
import ru.yandex.sashanc.citbars.contractserver.model.pojo.Contract;
import ru.yandex.sashanc.citbars.contractserver.repository.dao.ContractDaoImpl;
import ru.yandex.sashanc.citbars.contractserver.repository.dao.IContractDao;
import ru.yandex.sashanc.citbars.contractserver.model.dto.ContractDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractServerImpl implements IContractServer {
    @Override
    public List<ContractDto> getContractDtoList() {
        IContractDao contractDao = new ContractDaoImpl();
        ContractDto contractDto;
        List<ContractDto> contractDtoList = new ArrayList<>();
        for (Contract contract : contractDao.getContractList()) {
            contractDto = new ContractDto();
            contractDto.setId(contract.getId());
            contractDto.setName(contract.getName());
            contractDto.setContractDate(contract.getContractDate());
            contractDto.setContractUsingDate(contract.getContractUsingDate());
            int difDays = contract.getContractUsingDate().compareTo(contract.getContractDate());
            if (difDays > 30) {
                contractDto.setStatus("NotActive");
            } else {
                contractDto.setStatus("Active");
            }
            contractDtoList.add(contractDto);
        }
        return contractDtoList;
    }
}
