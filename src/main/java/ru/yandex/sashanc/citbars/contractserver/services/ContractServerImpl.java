package ru.yandex.sashanc.citbars.contractserver.services;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.sashanc.citbars.contractserver.model.pojo.Contract;
import ru.yandex.sashanc.citbars.contractserver.repository.dao.ContractDaoImpl;
import ru.yandex.sashanc.citbars.contractserver.repository.dao.IContractDao;
import ru.yandex.sashanc.citbars.contractserver.repository.dto.ContractDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractServerImpl implements IContractServer {
    private static final Logger logger = Logger.getLogger(ContractServerImpl.class);

    @Override
    public List<ContractDto> getContractDtoList() {
        IContractDao contractDao = new ContractDaoImpl();
        ContractDto contractDto = null;
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
            logger.info("Method getContractDtoList() from class ContractServerImpl has been done: dif of days " + difDays + " for " + contractDto);
        }
        return contractDtoList;
    }
}
