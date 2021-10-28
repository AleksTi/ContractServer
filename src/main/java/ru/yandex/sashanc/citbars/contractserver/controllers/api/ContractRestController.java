package ru.yandex.sashanc.citbars.contractserver.controllers.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.yandex.sashanc.citbars.contractserver.model.dto.ContractDto;
import ru.yandex.sashanc.citbars.contractserver.services.ContractServerImpl;
import ru.yandex.sashanc.citbars.contractserver.services.IContractServer;

import java.util.List;

@RestController
public class ContractRestController {
    private static final Logger logger = Logger.getLogger(ContractRestController.class);

    @RequestMapping("/" )
    public String welcome(){
        return "Welcome to Contract Server!";
    }

    @RequestMapping("/rest")
    public String welcomeToRest(){
        return "Welcome to Contract Server REST service!";
    }

    @GetMapping(value = "/contract/{action}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String contractHandler(@PathVariable String action) {
        IContractServer contractServer = new ContractServerImpl();
        List<ContractDto> contractDtoList = contractServer.getContractDtoList();
        String jsonString = "null";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonString = objectMapper.writeValueAsString(contractDtoList);
        } catch (JsonProcessingException e) {
            logger.info("JSON", e);
        }
        return jsonString;
    }
}
