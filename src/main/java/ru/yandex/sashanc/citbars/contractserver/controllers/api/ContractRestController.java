package ru.yandex.sashanc.citbars.contractserver.controllers.api;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
