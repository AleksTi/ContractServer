package ru.yandex.sashanc.citbars.contractserver.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.yandex.sashanc.citbars.contractserver.services.IContractServer;

@RestController
public class ContractRestController {
    private final IContractServer contractServer;

    @Autowired
    public ContractRestController(IContractServer contractServer) {
        this.contractServer = contractServer;
    }

    @RequestMapping("/" )
    public String welcome(){
        return "Welcome to Contract Server!";
    }

    @RequestMapping("/rest")
    public String welcomeToRest(){
        return "Welcome to Contract Server REST service!";
    }

    @GetMapping(value = "/contract/{action}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String contractHandler(@PathVariable String action) {
        return contractServer.getJsonStringContractDtoList();
    }
}
