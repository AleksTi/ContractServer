package ru.yandex.sashanc.citbars.contractserver.controllers.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.sashanc.citbars.contractserver.repository.dto.ContractDto;
import ru.yandex.sashanc.citbars.contractserver.services.ContractServerImpl;
import ru.yandex.sashanc.citbars.contractserver.services.IContractServer;

import java.util.List;

@RestController
public class ContractRestController {
    @RequestMapping("/" )
    public String welcome(){
        return "Welcome to Contract Server!";
    }

    @RequestMapping("/rest")
    public String welcomeToRest(){
        return "Welcome to Contract Server REST service!";
    }

    @RequestMapping(value = "/contract/{action}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ContractDto> contractHandler(@PathVariable String action){
        IContractServer contractServer = new ContractServerImpl();
        List<ContractDto> contractDtoList = contractServer.getContractDtoList();
        System.out.println(contractDtoList);
        return contractDtoList;
    }
}
