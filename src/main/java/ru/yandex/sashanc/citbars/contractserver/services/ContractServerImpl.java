package ru.yandex.sashanc.citbars.contractserver.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.sashanc.citbars.contractserver.model.pojo.Contract;
import ru.yandex.sashanc.citbars.contractserver.repository.dao.IContractDao;
import ru.yandex.sashanc.citbars.contractserver.model.dto.ContractDto;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContractServerImpl implements IContractServer {
    private static final Logger logger = Logger.getLogger(ContractServerImpl.class);

    private final IContractDao contractDao;

    @Autowired
    public ContractServerImpl(IContractDao contractDao) {
        this.contractDao = contractDao;
    }

    @Override
    public List<ContractDto> getContractDtoList() {
        ContractDto contractDto;
        List<ContractDto> contractDtoList = new ArrayList<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        for (Contract contract : contractDao.getContractList()) {
            contractDto = new ContractDto();
            contractDto.setId(contract.getId());
            contractDto.setName(contract.getName());
            contractDto.setContractDate(contract.getContractDate().format(dateTimeFormatter));
            contractDto.setContractUsingDate(contract.getContractUsingDate().format(dateTimeFormatter));
            long difDays = contract.getContractUsingDate().toEpochDay() - contract.getContractDate().toEpochDay();
            if (difDays > 60) {
                contractDto.setStatus("Not Active");
            } else {
                contractDto.setStatus("Active");
            }
            contractDtoList.add(contractDto);
        }
        return contractDtoList;
    }

    @Override
    public String getJsonStringContractDtoList() {
        List<ContractDto> contractDtoList = getContractDtoList();
        String jsonString = "null";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonString = objectMapper.writeValueAsString(contractDtoList);
        } catch (JsonProcessingException e) {
            logger.info("Error converting JSON to string", e);
        }
        return jsonString;
    }
}
